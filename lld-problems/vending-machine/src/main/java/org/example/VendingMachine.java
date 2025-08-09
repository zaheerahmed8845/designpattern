package org.example;

import org.example.entity.*;
import org.example.enums.Denomination;
import org.example.exception.InsufficientChangeException;
import org.example.observer.MachineObserver;
import org.example.state.DispenseState;
import org.example.state.NoMoneyInsertedState;
import org.example.state.State;
import org.example.strategy.CashPayment;
import org.example.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class VendingMachine {
    // Singleton
    private static final VendingMachine INSTANCE = new VendingMachine();

    private State currentState = new NoMoneyInsertedState();
    private double currentAmount = 0.0; // ₹
    private Integer selectedRack = null;
    private final Inventory inventory = new Inventory();

    // New: observers, payment, change & cash inventory
    private final List<MachineObserver> observers = new ArrayList<>();
    private PaymentStrategy payment = new CashPayment(this);
    private ChangeCalculator changeCalc = new GreedyChangeCalculator();
    private final CashInventory cashInventory = new CashInventory();

    private VendingMachine() {
    }

    public static VendingMachine getInstance() {
        return INSTANCE;
    }

    // ---- Observer helpers ----
    public void addObserver(MachineObserver o) {
        observers.add(o);
    }

    private void notifyState(String from, String to) {
        observers.forEach(o -> o.onStateChanged(from, to));
    }

    void notifyInv(int rack, int qty) {
        observers.forEach(o -> o.onInventoryChanged(rack, qty));
    }

    void fault(String msg) {
        observers.forEach(o -> o.onFault(msg));
    }

    public void message(String msg) {
        observers.forEach(o -> o.onMessage(msg));
    }

    // ---- public API (diagram + extras) ----
    public synchronized void insertMoney(double amount) {
        currentState.insertMoney(this, amount);
    }

    public synchronized void selectProduct(int rackNumber) {
        currentState.selectProduct(this, rackNumber);
    }

    public synchronized void dispenseProduct() {
        if (!(currentState instanceof DispenseState)) {
            message("Cannot dispense in current state.");
            return;
        }
        if (selectedRack == null) {
            message("No product selected.");
            setState(new NoMoneyInsertedState());
            return;
        }

        Rack rack = safeGetRack(selectedRack);
        if (rack.isEmpty()) {
            message("Oops, out of stock. Refunding.");
            refund();
            return;
        }

        double price = rack.getProduct().getPrice();

        try {
            // Capture payment BEFORE physically dispensing (or use 2-phase if needed)
            if (!payment.capture(price)) {
                message("Payment capture failed.");
                refund();
                return;
            }

            rack.dispenseOne();
            notifyInv(rack.getRackNumber(), rack.getQuantity());

            // Handle change if cash
            if (payment instanceof CashPayment) {
                double change = currentAmount - price;
                if (change > 0) {
                    returnChange(change);
                }
                currentAmount = 0.0;
            }
            message("Dispensed: " + rack.getProduct().getName());
            selectedRack = null;
            setState(new NoMoneyInsertedState());
        } catch (Exception jam) {
            fault("Dispense failed: " + jam.getMessage());
            refund();
        }
    }

    public synchronized void refund() {
        if (payment instanceof CashPayment && currentAmount > 0) {
            returnChange(currentAmount);
        } else {
            payment.refund(currentAmount); // card path (amount is 0 for card pre-dispense)
        }
        currentAmount = 0.0;
        selectedRack = null;
        setState(new NoMoneyInsertedState());
    }

    public synchronized void addRack(Rack rack) {
        inventory.addRack(rack);
    }

    public synchronized void loadProduct(int rackNumber, Product product, int qty) {
        Rack r = inventory.getRack(rackNumber);
        if (r.getProduct().getId() != product.getId()) {
            throw new IllegalArgumentException("Rack " + rackNumber + " already holds " + r.getProduct().getName());
        }
        r.loadProduct(qty);
        notifyInv(rackNumber, r.getQuantity());
    }

    public synchronized void showInventory() {
        inventory.allRacks().forEach(r ->
                System.out.println("[" + r.getRackNumber() + "] " +
                        r.getProduct().getName() + " ₹" + r.getProduct().getPrice() +
                        " x " + r.getQuantity())
        );
    }

    // Cash float management (maintenance)
    public synchronized void loadFloat(Denomination d, int qty) {
        cashInventory.add(d, qty);
    }

    public synchronized Map<Denomination, Integer> cashSnapshot() {
        return cashInventory.snapshot();
    }

    // ---- internal helpers used by states/strategies ----
    public void setState(State s) {
        String from = currentState.getClass().getSimpleName();
        String to = s.getClass().getSimpleName();
        this.currentState = s;
        notifyState(from, to);
    }

    public void incrementAmount(double amount) {
        this.currentAmount += amount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setSelectedRack(int rackNumber) {
        this.selectedRack = rackNumber;
    }

    public Rack safeGetRack(int rackNumber) {
        try {
            return inventory.getRack(rackNumber);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Invalid rack: " + rackNumber);
        }
    }

    public PaymentStrategy getPayment() {
        return payment;
    }

    public void setPayment(PaymentStrategy p) {
        this.payment = p;
        message("Payment set to " + p.name());
    }

    // Change return using strategy + cash inventory
    void returnChange(double changeRupees) {
        int paise = toPaise(changeRupees);
        try {
            var plan = changeCalc.calculate(paise, cashInventory);
            // apply (remove from float) and print
            for (var e : plan.entrySet()) {
                cashInventory.take(e.getKey(), e.getValue());
            }
            message("Please take your change: ₹" + format(changeRupees) + " " + plan);
        } catch (InsufficientChangeException e) {
            fault("Insufficient change available. Please contact support.");
        }
    }

    int toPaise(double rupees) {
        return (int) Math.round(rupees * 100.0);
    }

    public String format(double rupees) {
        return String.format("%.2f", rupees);
    }
}

