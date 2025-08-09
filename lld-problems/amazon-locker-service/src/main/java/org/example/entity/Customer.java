package org.example.entity;

import java.util.Objects;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone;

    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = Objects.requireNonNull(customerId);
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
        this.phone = Objects.requireNonNull(phone);
    }

    public void placeOrder(Order order) {
        // TODO: route to order service
    }

    public void requestReturn() {
        // TODO: initiate return flow
    }

    public boolean verifyOTP() {
        // TODO: OTP verification
        return true;
    }

    public void receiveNotification(Notification notification) {
        // Hook for UI/mobile app
        notification.send();
    }

    // getters omitted for brevity
}

