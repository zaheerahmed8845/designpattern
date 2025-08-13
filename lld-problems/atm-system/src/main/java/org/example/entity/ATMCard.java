package org.example.entity;

import java.time.LocalDate;

public record ATMCard(String cardNumber, String customerName, LocalDate cardExpiryDate, String pinMasked) {
}

