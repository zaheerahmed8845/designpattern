package org.example.payment;

import org.example.enums.PaymentStatus;

import java.time.Instant;
import java.util.Objects;

public class PaymentResult {
    private final PaymentStatus status;
    private final String referenceId;
    private final String message;
    private final Instant timestamp = Instant.now();

    public PaymentResult(PaymentStatus status, String referenceId, String message) {
        this.status = Objects.requireNonNull(status);
        this.referenceId = referenceId;
        this.message = message;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public boolean approved() {
        return status == PaymentStatus.APPROVED;
    }
}
