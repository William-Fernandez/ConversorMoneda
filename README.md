# 💰 ¡Conversor de Moneda Simple y Rápido! 🚀

Una herramienta de consola que permite convertir entre distintas divisas de forma sencilla y obtener los tipos de cambio actualizados al instante.

[![Java JDK](https://img.shields.io/badge/Java_JDK-8+-orange.svg?style=flat-square)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![Gson Library](https://img.shields.io/badge/Gson-2.8.9+-green.svg?style=flat-square)](https://github.com/google/gson)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-Community-blue.svg?style=flat-square)](https://www.jetbrains.com/idea/community/)
[![API](https://img.shields.io/badge/API-ExchangeRate--API-yellow.svg?style=flat-square)](https://www.exchangerate-api.com/)
[![Estado](https://img.shields.io/badge/Estado-En%20Desarrollo-yellowgreen.svg?style=flat-square)](https://github.com/William-Fernandez/ConversorMoneda)

## 🧭 Índice

1.  [¿Qué hace esta aplicación?](#¿qué-hace-esta-aplicación)
2.  [¡Pruébalo! (Demostración)](#¡pruébalo-demostración)
3.  [¿Cómo usarlo? (Acceso)](#¿cómo-usarlo-acceso)
4.  [Construido con... (Tecnologías)](#construido-con-tecnologías)
5.  [¡Manos a la obra! (Desarrolladores)](#¡manos-a-la-obra-desarrolladores)
6.  [¿Quién más ayudó? (Contribuyentes)](#¿quién-más-ayudó-contribuyentes)
7.  [¡Libre para todos! (Licencia)](#¡libre-para-todos-licencia)

## 💡 ¿Qué hace esta aplicación?

Esta es una aplicación de consola simple y directa que te permite convertir divisas de forma rápida y sencilla.
Solo necesitas ingresar los códigos de tres letras de las monedas (por ejemplo, USD, EUR, COP) y la cantidad que deseas convertir.
¡Obtendrás el resultado al instante! Además, incluye una guía rápida para ayudarte a encontrar los códigos de las monedas.

Ahora también puedes consultar un historial de conversiones realizadas, incluyendo la fecha y hora exacta en que se hicieron.

## ⚙️ Estado del proyecto

Actualmente, este proyecto está **en desarrollo activo**. Se están implementando nuevas funciones y mejorando la experiencia del usuario.
¡Mantente atento a las actualizaciones!

## ✨ ¡Pruébalo! (Demostración)

Aunque esta es una aplicación de consola, aquí te mostramos cómo funciona:

1.  Al ejecutar la aplicación, verás un menú con las siguientes opciones:
    ```
    --- Conversor de Moneda ---
    1. Guía de Códigos de Moneda
    2. Iniciar Conversión
    3. Ver Historial de Conversiones
    4. Salir
    ```

2.  **Para ver la guía de códigos de moneda:** Selecciona la opción `1`. Se mostrará una lista de códigos comunes para ayudarte.

    ```
    --- Guía de Códigos de Moneda ---
    Para realizar la conversión, necesitarás ingresar los códigos de tres letras que representan cada moneda. Aquí tienes algunos ejemplos comunes:

    Colombia: COP
    Estados Unidos: USD
    Europa: EUR
    Reino Unido: GBP
    Japón: JPY
    Canadá: CAD
    Australia: AUD
    Suiza: CHF

    Puedes buscar el código de cualquier otra moneda en línea si no la encuentras en esta lista.
    --- Fin de la Guía ---
    ```

3.  **Para iniciar una conversión:** Selecciona la opción `2`. La aplicación te pedirá:
    ```
    Ingrese la moneda base (ej: USD):
    ```
    Ingresa el código de la moneda desde la que quieres convertir. Luego, te pedirá:
    ```
    Ingrese la moneda a convertir (ej: EUR):
    ```
    Ingresa el código de la moneda a la que quieres convertir. Finalmente, te preguntará:
    ```
    Ingrese la cantidad de [Moneda Base] a convertir:
    ```
    Ingresa el número que deseas convertir. La aplicación te mostrará el resultado.

    ```
    --- Resultado de la Conversión ---
    Moneda Base: USD
    1 USD equivale a 0.88 EUR
    Ingrese la cantidad de USD a convertir: 10
    10 USD son 8.80 EUR
    ```

    Esta conversión se guardará automáticamente en el historial, incluyendo la fecha y hora.

4.  **Para ver el historial de conversiones:** Selecciona la opción `3`. Verás una lista con todas las conversiones realizadas, incluyendo la tasa usada, el monto convertido y la fecha/hora en que se hicieron.

    ```
    --- Historial de Conversiones ---
    [2025-05-03T14:25:17.123] 10.0 USD → 8.80 EUR (Tasa: 0.88)
    ```

5.  **Para salir:** Selecciona la opción `4`.

Después de cada conversión o consulta, la aplicación te mostrará el menú nuevamente para que puedas seguir utilizando el programa.

## 🚀 ¿Cómo usarlo? (Acceso)

Para ejecutar esta aplicación en tu computadora, necesitas tener Java JDK instalado. Sigue estos pasos:

1.  **Clonar el Repositorio (si el código está en un repositorio):**
    ```bash
    git clone [https://github.com/William-Fernandez/ConversorMoneda.git](https://github.com/William-Fernandez/ConversorMoneda.git)
    cd ConversorMoneda
    ```

2.  **Compilar el Código Java:** Abre una terminal o símbolo del sistema en la raíz del proyecto (`ConversorMoneda`) y compila los archivos Java:
    ```bash
    javac com/aluracursos/conversormoneda/*.java com/aluracursos/conversormoneda/model/*.java
    ```

3.  **Ejecutar la Aplicación:** Ejecuta la clase principal (`MainConverter`):
    ```bash
    java com.aluracursos.conversormoneda.MainConverter
    ```

¡La aplicación se iniciará y podrás seguir las instrucciones en la consola!

## 🛠️ Construido con... (Tecnologías)

Esta aplicación se ha desarrollado utilizando las siguientes tecnologías:

* **Java JDK:** El kit de desarrollo de Java para escribir y ejecutar la aplicación.
  [![Java JDK](https://img.shields.io/badge/Java_JDK-8+-orange.svg?style=flat-square)](https://www.oracle.com/java/technologies/javase-downloads.html)
* **Gson Library:** Una biblioteca Java de Google para convertir objetos Java en su representación JSON y viceversa. Se utiliza para analizar la respuesta de la API.
  [![Gson Library](https://img.shields.io/badge/Gson-2.8.9+-green.svg?style=flat-square)](https://github.com/google/gson)
* **ExchangeRate-API:** La API externa utilizada para obtener los tipos de cambio actualizados.
  [![API](https://img.shields.io/badge/API-ExchangeRate--API-yellow.svg?style=flat-square)](https://www.exchangerate-api.com/)
* **IntelliJ IDEA:** El entorno de desarrollo integrado (IDE) utilizado para escribir y depurar el código.
  [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-Community-blue.svg?style=flat-square)](https://www.jetbrains.com/idea/community/)
* **java.time (LocalDateTime):** Utilizado para registrar la fecha y hora exacta de cada conversión realizada en el historial.
* **Sistema de historial de conversiones:** Implementado mediante una lista de objetos que almacena cada conversión realizada con detalles completos.

## 🧑‍💻 ¡Manos a la obra! (Desarrolladores)

Este proyecto ha sido desarrollado por:

* William Fernandez ([William-Fernandez](https://github.com/William-Fernandez))

¡Gracias por crear esta increíble aplicación!

## 🤝 ¿Quién más ayudó? (Contribuyentes)

¡Por ahora, este proyecto es individual! Sin embargo, si alguien contribuye en el futuro, sus nombres aparecerán aquí con enlaces a sus perfiles.
¡Las contribuciones son bienvenidas!

## 📄 ¡Libre para todos! (Licencia)

Este proyecto está bajo la licencia **MIT**.
Consulta el archivo `LICENSE` en la raíz del repositorio para obtener más detalles sobre los términos y condiciones de uso.

[![Licencia](https://img.shields.io/badge/Licencia-MIT-blue.svg?style=flat-square)](./LICENSE)
