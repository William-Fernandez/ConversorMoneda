# 💰 Simple and Speedy Currency Converter! 🚀

A console tool that allows you to convert between different currencies easily and get the latest exchange rates instantly.

[![Java JDK](https://img.shields.io/badge/Java_JDK-8+-orange.svg?style=flat-square)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![Gson Library](https://img.shields.io/badge/Gson-2.8.9+-green.svg?style=flat-square)](https://github.com/google/gson)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-Community-blue.svg?style=flat-square)](https://www.jetbrains.com/idea/community/)
[![API](https://img.shields.io/badge/API-ExchangeRate--API-yellow.svg?style=flat-square)](https://www.exchangerate-api.com/)
[![Status](https://img.shields.io/badge/Status-In%20Development-yellowgreen.svg?style=flat-square)](https://github.com/William-Fernandez/ConversorMoneda)

## 🧭 Contents

1.  [What does this application do?](#what-does-this-application-do)
2.  [Have a go! (Demonstration)](#have-a-go-demonstration)
3.  [How to use it? (Access)](#how-to-use-it-access)
4.  [Built with... (Technologies)](#built-with-technologies)
5.  [Get stuck in! (Developers)](#get-stuck-in-developers)
6.  [Who else helped? (Contributors)](#who-else-helped-contributors)
7.  [Free for all! (License)](#free-for-all-license)

## 💡 What does this application do?

This is a simple and straightforward console application that allows you to convert currencies quickly and easily.
You just need to enter the three-letter codes for the currencies (for example, USD, EUR, COP) and the amount you want to convert.
You'll get the result instantly! Plus, it includes a quick guide to help you find the currency codes.

Now you can also check a history of conversions made, including the exact date and time they occurred.

## ⚙️ Project Status

Currently, this project is **in active development**. New features are being implemented and the user experience is being improved.
Stay tuned for updates!

## ✨ Have a go! (Demonstration)

Although this is a console application, here's how it works:

1.  When you run the application, you'll see a menu with the following options:
    ```
    --- Currency Converter ---
    1. Currency Code Guide
    2. Start Conversion
    3. View Conversion History
    4. Exit
    ```

2.  **To see the currency code guide:** Select option `1`. A list of common codes will be displayed to help you.

    ```
    --- Currency Code Guide ---
    To perform the conversion, you will need to enter the three-letter codes that represent each currency. Here are some common examples:

    Colombia: COP
    United States: USD
    Europe: EUR
    United Kingdom: GBP
    Japan: JPY
    Canada: CAD
    Australia: AUD
    Switzerland: CHF

    You can search for the code of any other currency online if you don't find it in this list.
    --- End of Guide ---
    ```

3.  **To start a conversion:** Select option `2`. The application will ask you for:
    ```
    Enter the base currency (e.g., USD):
    ```
    Enter the code of the currency you want to convert from. Then, it will ask you for:
    ```
    Enter the currency to convert to (e.g., EUR):
    ```
    Enter the code of the currency you want to convert to. Finally, it will ask:
    ```
    Enter the amount of [Base Currency] to convert:
    ```
    Enter the number you want to convert. The application will show you the result.

    ```
    --- Conversion Result ---
    Base Currency: USD
    1 USD is equivalent to 0.88 EUR
    Enter the amount of USD to convert: 10
    10 USD is 8.80 EUR
    ```

    This conversion will be automatically saved in the history, including the date and time.

4.  **To view the conversion history:** Select option `3`. You will see a list with all the conversions made, including the rate used, the amount converted, and the date/time they were made.

    ```
    --- Conversion History ---
    [2025-05-03T14:25:17.123] 10.0 USD → 8.80 EUR (Rate: 0.88)
    ```

5.  **To exit:** Select option `4`.

After each conversion or query, the application will show you the menu again so you can continue using the program.

## 🚀 How to use it? (Access)

To run this application on your computer, you need to have Java JDK installed. Follow these steps:

1.  **Clone the Repository (if the code is in a repository):**
    ```bash
    git clone [https://github.com/William-Fernandez/ConversorMoneda.git](https://github.com/William-Fernandez/ConversorMoneda.git)
    cd ConversorMoneda
    ```

2.  **Compile the Java Code:** Open a terminal or command prompt in the project root (`ConversorMoneda`) and compile the Java files:
    ```bash
    javac com/aluracursos/conversormoneda/*.java com/aluracursos/conversormoneda/model/*.java
    ```

3.  **Run the Application:** Execute the main class (`MainConverter`):
    ```bash
    java com.aluracursos.conversormoneda.MainConverter
    ```

The application will start, and you can follow the instructions in the console!

## 🛠️ Built with... (Technologies)

This application has been developed using the following technologies:

* **Java JDK:** The Java Development Kit used to write and run the application.
  [![Java JDK](https://img.shields.io/badge/Java_JDK-8+-orange.svg?style=flat-square)](https://www.oracle.com/java/technologies/javase-downloads.html)
* **Gson Library:** A Java library by Google for converting Java objects into their JSON representation and vice versa. It is used to parse the API response.
  [![Gson Library](https://img.shields.io/badge/Gson-2.8.9+-green.svg?style=flat-square)](https://github.com/google/gson)
* **ExchangeRate-API:** The external API used to obtain the latest exchange rates.
  [![API](https://img.shields.io/badge/API-ExchangeRate--API-yellow.svg?style=flat-square)](https://www.exchangerate-api.com/)
* **IntelliJ IDEA:** The Integrated Development Environment (IDE) used to write and debug the code.
  [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-Community-blue.svg?style=flat-square)](https://www.jetbrains.com/idea/community/)
* **java.time (LocalDateTime):** Used to record the exact date and time of each conversion performed in the history.
* **Conversion history system:** Implemented using a list of objects that stores each conversion performed with complete details.

## 🧑‍💻 Get stuck in! (Developers)

This project has been developed by:

* William Fernandez ([William-Fernandez](https://github.com/William-Fernandez))

Thank you for creating this amazing application!

## 🤝 Who else helped? (Contributors)

For now, this project is an individual effort! However, if anyone contributes in the future, their names will appear here with links to their profiles.
Contributions are welcome!

## 📄 Free for all! (License)

This project is under the **MIT License**.
See the `LICENSE` file at the root of the repository for more details about the terms and conditions of use.

[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat-square)](./LICENSE)