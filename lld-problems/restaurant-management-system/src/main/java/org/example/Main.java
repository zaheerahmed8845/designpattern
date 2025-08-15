package org.example;

import org.example.builder.Meal;
import org.example.builder.MealItem;
import org.example.composite.Menu;
import org.example.composite.MenuItem;
import org.example.composite.MenuSection;
import org.example.entity.*;
import org.example.person.Customer;
import org.example.person.Waiter;
import org.example.strategy.CashPayment;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Composite menu
        Menu menu = new Menu(1, "All Day Menu", "Starters, Mains, Desserts");
        MenuSection mains = new MenuSection("Mains", "Hearty plates");
        MenuItem biryani = new MenuItem("Chicken Biryani", "Aromatic rice and chicken", 280.0);
        MenuItem curry = new MenuItem("Butter Chicken", "Creamy tomato gravy", 320.0);
        mains.add(biryani);
        mains.add(curry);
        menu.add(mains);

        // Table & Waiter
        Table table = new Table(101, 4, "G1", 4);
        Waiter waiter = new Waiter();

        // Build a meal
        Meal meal = new Meal.Builder()
                .id(5001)
                .addItem(new MealItem(biryani, 2))
                .addItem(new MealItem(curry, 1))
                .build();

        // Place order
        Order order = new Order(9001, table, waiter);
        order.addMeal(meal);

        // Billing + payment (Template + Strategy + Singleton)
        Bill bill = new Bill(order);
        BillingService.getInstance().prepareBill(bill);
        PaymentProcessor processor = new DefaultPaymentProcessor();
        boolean paid = processor.process(bill, new CashPayment(1000.0));
        System.out.println("Bill paid? " + paid);

        // Reservation (Builder + Singleton)
        Customer customer = new Customer("Zaheer", "z@example.com", "9999999999");
        Reservation reservation = new Reservation.Builder()
                .id("RSV-1001")
                .at(LocalDateTime.now().plusDays(1))
                .forPeople(4)
                .by(customer)
                .addTable(table)
                .notes("Window seat if possible")
                .build();
        ReservationManager.getInstance().save(reservation);
        System.out.println("Reservation saved: " + reservation.getReservationId());
    }
}