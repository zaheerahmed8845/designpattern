package org.example.person;

import org.example.entity.VehicleReservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Receptionist extends Account {
    private LocalDateTime dateJoined;

    public Receptionist(String accountId, String password, LocalDateTime dateJoined) {
        super(accountId, password);
        this.dateJoined = dateJoined;
    }

    public List<Customer> searchCustomer(String name, List<Customer> db) {
        List<Customer> res = new ArrayList<>();
        for (Customer c : db) {
            if (c != null && name != null && name.equalsIgnoreCase(c.getAccountId())) {
                res.add(c);
            }
        }
        return res;
    }

    public boolean addReservation(Customer customer, VehicleReservation r) {
        return customer.addReservation(r);
    }

    public boolean cancelReservation(Customer customer, int reservationId) {
        return customer.cancelReservation(reservationId);
    }
}
