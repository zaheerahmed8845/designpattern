package org.example.entity.payment;

import org.example.enums.PaymentStatus;

import java.time.LocalDateTime;

public abstract class Payment {
    public double amount;
    PaymentStatus status;
    public LocalDateTime timestamp;

    public abstract boolean initiateTransaction();
}
