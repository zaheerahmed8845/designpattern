package org.example.entity;

import org.example.builder.Meal;
import org.example.enums.OrderStatus;
import org.example.person.Waiter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderId;
    private OrderStatus status;
    private final List<Meal> meals = new ArrayList<>();
    private final Instant createdOn = Instant.now();
    private final Table table;
    private final Waiter waiter;

    public Order(int orderId, Table table, Waiter waiter) {
        this.orderId = orderId;
        this.table = table;
        this.waiter = waiter;
        this.status = OrderStatus.RECEIVED;
    }

    public boolean addMeal(Meal meal) {
        return meals.add(meal);
    }

    public double total() {
        return meals.stream().mapToDouble(Meal::total).sum();
    }

    public List<Meal> getMeals() {
        return List.copyOf(meals);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus s) {
        this.status = s;
    }

    public int getOrderId() {
        return orderId;
    }
}
