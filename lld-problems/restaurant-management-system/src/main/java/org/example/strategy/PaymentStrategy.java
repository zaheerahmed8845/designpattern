package org.example.strategy;

import org.example.entity.Bill;

public interface PaymentStrategy {
    boolean charge(Bill bill);
}
