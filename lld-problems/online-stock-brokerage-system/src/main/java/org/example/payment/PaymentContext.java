package org.example.payment;

import org.example.account.Member;

import java.math.BigDecimal;
import java.util.Objects;

public class PaymentContext {
    private PaymentMethod method;

    public PaymentContext(PaymentMethod method) {
        this.method = Objects.requireNonNull(method);
    }

    public void setMethod(PaymentMethod method) {
        this.method = Objects.requireNonNull(method);
    }

    public PaymentResult execute(Member member, BigDecimal amount) {
        return method.pay(member, amount);
    }
}
