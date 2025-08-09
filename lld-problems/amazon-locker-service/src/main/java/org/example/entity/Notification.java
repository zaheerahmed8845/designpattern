package org.example.entity;

import java.util.Objects;

public class Notification {
    private String customerId;
    private String orderId;
    private String lockerId;
    private String code;

    public Notification(String customerId, String orderId, String lockerId, String code) {
        this.customerId = Objects.requireNonNull(customerId);
        this.orderId = Objects.requireNonNull(orderId);
        this.lockerId = Objects.requireNonNull(lockerId);
        this.code = Objects.requireNonNull(code);
    }

    public void send() {
        // TODO: integrate with email/SMS/push
        System.out.printf("Notified customer %s for order %s (locker %s, code %s)%n",
                customerId, orderId, lockerId, code);
    }

    // getters
    public String getCustomerId() {
        return customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getLockerId() {
        return lockerId;
    }

    public String getCode() {
        return code;
    }
}
