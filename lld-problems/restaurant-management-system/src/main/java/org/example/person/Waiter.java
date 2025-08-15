package org.example.person;

import org.example.composite.Menu;
import org.example.entity.Bill;
import org.example.entity.Order;

import java.util.List;

public class Waiter extends Person {
    public boolean addOrder(Order o) {
        return true;
    }

    public List<Order> fetchOrders() {
        return List.of();
    }

    public Bill generateBill(Order o) {
        return new Bill(o);
    }

    public Menu viewMenu(Menu menu) {
        return menu;
    }
}
