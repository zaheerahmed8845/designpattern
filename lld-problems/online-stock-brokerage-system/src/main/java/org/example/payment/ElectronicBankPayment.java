package org.example.payment;

import org.example.account.Member;
import org.example.enums.PaymentStatus;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class ElectronicBankPayment implements PaymentMethod {
    private final String bankAccountNumber;

    public ElectronicBankPayment(String bankAccountNumber) {
        this.bankAccountNumber = Objects.requireNonNull(bankAccountNumber);
    }

    @Override
    public String name() {
        return "ElectronicBank";
    }

    @Override
    public PaymentResult pay(Member member, BigDecimal amount) {
        if (member == null || amount == null || amount.signum() <= 0) {
            return new PaymentResult(PaymentStatus.DECLINED, null, "Invalid payment request");
        }
        // Simulate success
        member.deposit(amount);
        return new PaymentResult(PaymentStatus.APPROVED, UUID.randomUUID().toString(),
                "Electronic bank transfer approved to " + member.getId());
    }
}
