package org.example.person;

import org.example.entity.Order;
import org.example.entity.Reservation;
import org.example.entity.Table;

import java.util.List;

public class Customer extends Person {

    public Customer() {
    }

    public Customer(String name, String email, String phone) {
        super(name, email, phone, null, null);
    }

    public Reservation makeReservation(Reservation reservation) {
        return reservation;
    }

    public boolean cancelReservation(Reservation reservation) {
        return true;
    }

    public List<Table> searchAvailableTables() {
        return List.of();
    }

    public Order placeOrder(Order order) {
        return order;
    }
}
