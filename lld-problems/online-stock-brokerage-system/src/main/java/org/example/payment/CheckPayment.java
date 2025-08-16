package org.example.payment;

import org.example.account.Member;
import org.example.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class CheckPayment implements PaymentMethod {
    private final String checkNumber;
    private final LocalDate depositDate;

    public CheckPayment(String checkNumber, LocalDate depositDate) {
        this.checkNumber = Objects.requireNonNull(checkNumber);
        this.depositDate = Objects.requireNonNull(depositDate);
    }

    @Override
    public String name() {
        return "Check";
    }

    @Override
    public PaymentResult pay(Member member, BigDecimal amount) {
        if (member == null || amount == null || amount.signum() <= 0) {
            return new PaymentResult(PaymentStatus.DECLINED, null, "Invalid payment request");
        }
        // Simulate longer clearing; here we immediately approve to keep it simple
        member.deposit(amount);
        return new PaymentResult(PaymentStatus.APPROVED, UUID.randomUUID().toString(),
                "Check #" + checkNumber + " cleared for " + member.getId());
    }
}
