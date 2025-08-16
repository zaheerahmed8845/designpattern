package org.example.payment;

import org.example.account.Member;
import org.example.enums.PaymentStatus;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class WirePayment implements PaymentMethod {
    private final String swiftCode;
    private final String iban;

    public WirePayment(String swiftCode, String iban) {
        this.swiftCode = Objects.requireNonNull(swiftCode);
        this.iban = Objects.requireNonNull(iban);
    }

    @Override
    public String name() {
        return "Wire";
    }

    @Override
    public PaymentResult pay(Member member, BigDecimal amount) {
        if (member == null || amount == null || amount.signum() <= 0) {
            return new PaymentResult(PaymentStatus.DECLINED, null, "Invalid payment request");
        }
        // Simulate pending → approved
        member.deposit(amount);
        return new PaymentResult(PaymentStatus.APPROVED, UUID.randomUUID().toString(),
                "Wire received for " + member.getId());
    }
}
