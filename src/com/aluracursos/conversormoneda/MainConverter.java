package com.aluracursos.conversormoneda;

import com.google.gson.Gson;
import com.aluracursos.conversormoneda.model.ExchangeRateResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class MainConverter {
    private static final String API_KEY = "e05624c2ff479b4fb79bc4b6";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después de leer el entero.

                switch (opcion) {
                    case 1:
                        mostrarGuiaMonedas();
                        break;
                    case 2:
                        realizarConversion(scanner);
                        break;
                    case 3:
                        System.out.println("¡Gracias por usar el Conversor de Moneda!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción del menú.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del menú.");
                scanner.next(); // Limpiar el buffer del scanner.
                opcion = -1; // Para que el bucle continúe.
            }
            System.out.println(); // Salto de linea.
        } while (opcion != 3);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Bienvenido/a al Conversor de Moneda ---");
        System.out.println("1. Guía de Códigos de Moneda (ISO)");
        System.out.println("2. Iniciar Conversión");
        System.out.println("3. Salir");
    }

    private static void mostrarGuiaMonedas() {
        System.out.println("\n--- Guía de Códigos de Moneda (ISO)---");
        System.out.println("Aquí tienes algunos ejemplos comunes:\n");
        System.out.println("Colombia: COP");
        System.out.println("Estados Unidos: USD");
        System.out.println("Europa: EUR");
        System.out.println("Reino Unido: GBP");
        System.out.println("Japón: JPY");
        System.out.println("Canadá: CAD");
        System.out.println("Australia: AUD");
        System.out.println("Suiza: CHF\n");
        System.out.println("Puedes buscar el código de cualquier otra moneda en línea.");
        System.out.println("--- Fin de la Guía ---");
    }

    private static void realizarConversion(Scanner scanner) throws IOException, InterruptedException {
        System.out.print("Ingrese la moneda base (ej: USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la moneda a convertir (ej: EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        String apiUrl = BASE_URL + API_KEY + "/latest/" + baseCurrency;

        HttpResponse<String> response;
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }

        if (response.statusCode() == 200) {
            String jsonResponse = response.body();

            Gson gson = new Gson();
            ExchangeRateResponse exchangeRateResponse = gson.fromJson(jsonResponse, ExchangeRateResponse.class);

            if ("success".equals(exchangeRateResponse.getResult())) {
                System.out.println("\n--- Resultado de la Conversión ---");
                System.out.println("Moneda Base: " + exchangeRateResponse.getBaseCode());

                Double exchangeRate = exchangeRateResponse.getConversionRates().get(targetCurrency);

                if (exchangeRate != null) {
                    System.out.println("1 " + exchangeRateResponse.getBaseCode() + " equivale a " + exchangeRate + " " + targetCurrency);

                    System.out.print("Ingrese la cantidad de " + exchangeRateResponse.getBaseCode() + " a convertir: ");
                    try {
                        double amount = scanner.nextDouble();
                        double convertedAmount = amount * exchangeRate;
                        System.out.println(amount + " " + exchangeRateResponse.getBaseCode() + " son " + String.format("%.2f", convertedAmount) + " " + targetCurrency);
                    } catch (java.util.InputMismatchException e) {
                        System.err.println("Cantidad inválida. Por favor, ingrese un número.");
                        scanner.next(); // Limpiar el buffer del scanner.
                    }
                } else {
                    System.err.println("La moneda '" + targetCurrency + "' no fue encontrada en las tasas para " + exchangeRateResponse.getBaseCode() + ".");
                }
            } else {
                System.err.println("Error al obtener las tasas de cambio: " + exchangeRateResponse.getResult());
            }

        } else {
            System.err.println("Error en la petición HTTP. Código de estado: " + response.statusCode());
        }
    }
}
