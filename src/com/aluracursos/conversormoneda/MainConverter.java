package com.aluracursos.conversormoneda;

import com.google.gson.Gson;
import com.aluracursos.conversormoneda.model.ExchangeRateResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import com.aluracursos.conversormoneda.model.ConversionRecord;
import java.time.LocalDateTime;


public class MainConverter {
    private static final String API_KEY = "e05624c2ff479b4fb79bc4b6";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private static final List<ConversionRecord> historial = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            displayMenu();
            System.out.print("Select an option: ");
            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading the integer.

                switch (option) {
                    case 1:
                        displayCurrencyGuide();
                        break;
                    case 2:
                        performConversion(scanner);
                        break;
                    case 3:
                        displayHistory();
                        break;
                    case 4:
                        System.out.println("Thank you for using the Currency Converter!");
                        break;
                    default:
                        System.out.println("Invalid option. Please select an option from the menu.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from the menu.");
                scanner.next(); // Clear the scanner buffer.
                option = -1; // To ensure the loop continues.
            }
            System.out.println(); // Newline.
        } while (option != 3);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Welcome to the Currency Converter ---");
        System.out.println("1. Currency Code Guide (ISO)");
        System.out.println("2. Start Conversion");
        System.out.println("3. View Conversion History");
        System.out.println("4. Exit");

    }

    private static void displayCurrencyGuide() {
        System.out.println("\n--- Currency Code Guide (ISO) ---");
        System.out.println("Here are some common examples:\n");
        System.out.println("Colombia: COP");
        System.out.println("United States: USD");
        System.out.println("Europe: EUR");
        System.out.println("United Kingdom: GBP");
        System.out.println("Japan: JPY");
        System.out.println("Canada: CAD");
        System.out.println("Australia: AUD");
        System.out.println("Switzerland: CHF\n");
        System.out.println("You can search for the code of any other currency online.");
        System.out.println("--- End of Guide ---");
    }

    private static void displayHistory() {
        System.out.println("\n--- Conversion History ---");
        if (historial.isEmpty()) {
            System.out.println("There are no recorded conversions yet.");
        } else {
            for (ConversionRecord record : historial) {
                System.out.println(record);
            }
        }
    }


    private static void performConversion(Scanner scanner) throws IOException, InterruptedException {
        System.out.print("Enter the base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the currency to convert to (e.g., EUR): ");
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
                System.out.println("\n--- Conversion Result ---");
                System.out.println("Base Currency: " + exchangeRateResponse.getBaseCode());

                Double exchangeRate = exchangeRateResponse.getConversionRates().get(targetCurrency);

                if (exchangeRate != null) {
                    System.out.println("1 " + exchangeRateResponse.getBaseCode() + " is equivalent to " + exchangeRate + " " + targetCurrency);

                    System.out.print("Enter the amount of " + exchangeRateResponse.getBaseCode() + " to convert: ");
                    try {
                        double amount = scanner.nextDouble();
                        double convertedAmount = amount * exchangeRate;
                        System.out.println(amount + " " + baseCurrency + " is " + String.format("%.2f", convertedAmount) + " " + targetCurrency);
                        // Add to History
                        historial.add(new ConversionRecord(baseCurrency, targetCurrency, amount, convertedAmount, exchangeRate, LocalDateTime.now()));
                    } catch (java.util.InputMismatchException e) {
                        System.err.println("Invalid amount. Please enter a number.");
                        scanner.next(); // Clear the scanner buffer.
                    }
                } else {
                    System.err.println("The currency '" + targetCurrency + "' was not found in the rates for " + exchangeRateResponse.getBaseCode() + ".");
                }
            } else {
                System.err.println("Error fetching exchange rates: " + exchangeRateResponse.getResult());
            }

        } else {
            System.err.println("Error in the HTTP request. Status code: " + response.statusCode());
        }
    }
}
