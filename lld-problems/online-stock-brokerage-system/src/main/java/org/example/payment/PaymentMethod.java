package org.example.payment;

import org.example.account.Member;

import java.math.BigDecimal;

public interface PaymentMethod {
    String name();

    PaymentResult pay(Member member, BigDecimal amount);
}
