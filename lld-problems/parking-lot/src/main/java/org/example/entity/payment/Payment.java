package org.example.entity.payment;

import org.example.enums.PaymentStatus;

import java.time.LocalDateTime;

public abstract class Payment {
    double amount;
    PaymentStatus status;
    LocalDateTime timestamp;

    public abstract boolean initiateTransaction();
}
