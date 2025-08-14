package org.example.entity;

import org.example.customer.AuthenticatedUser;
import org.example.enums.OrderStatus;
import org.example.enums.PaymentStatus;
import org.example.observer.OrderObserver;
import org.example.payment.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Subject in Observer; holds list of observers and notifies on status change.
 */
public class Order {
    private final String orderNumber = UUID.randomUUID().toString();
    private AuthenticatedUser customer;
    private java.time.Instant orderDate = java.time.Instant.now();
    private OrderStatus status = OrderStatus.Unshipped;

    private final List<OrderObserver> observers = new ArrayList<>();

    // diagram methods:
    public boolean sendForShipment() {
        if (status == OrderStatus.Confirmed) {
            status = OrderStatus.Shipped;
            notifyObservers();
            return true;
        }
        return false;
    }

    public PaymentStatus makePayment(Payment payment) {
        PaymentStatus ps = payment.makePayment();
        if (ps == PaymentStatus.Confirmed) setStatus(OrderStatus.Confirmed);
        else if (ps == PaymentStatus.Declined) setStatus(OrderStatus.Canceled);
        return ps;
    }

    public boolean verify() {
        return customer != null;
    }

    // Observer helpers
    public void addObserver(OrderObserver o) {
        observers.add(o);
    }

    public void removeObserver(OrderObserver o) {
        observers.remove(o);
    }

    private void notifyObservers() {
        observers.forEach(o -> o.onOrderStatusChanged(this));
    }

    public void setStatus(OrderStatus s) {
        this.status = s;
        notifyObservers();
    }

    // getters
    public String getOrderNumber() {
        return orderNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setCustomer(AuthenticatedUser customer) {
        this.customer = customer;
    }
}
