package com.aluracursos.conversormoneda.model;

import java.time.LocalDateTime;

public class ConversionRecord {
    private String baseCurrency;
    private String targetCurrency;
    private double amount;
    private double convertedAmount;
    private double rate;
    private LocalDateTime timestamp;

    public ConversionRecord(String baseCurrency, String targetCurrency, double amount, double convertedAmount, double rate, LocalDateTime timestamp) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.rate = rate;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + amount + " " + baseCurrency + " → " + String.format("%.2f", convertedAmount) + " " + targetCurrency
                + " (Rate: " + rate + ")";
    }
}