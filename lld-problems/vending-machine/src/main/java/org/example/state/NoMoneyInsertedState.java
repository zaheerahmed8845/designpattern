package org.example.state;

import org.example.VendingMachine;
import org.example.entity.Rack;
import org.example.strategy.CashPayment;

public class NoMoneyInsertedState implements State {

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        if (!(machine.getPayment() instanceof CashPayment)) {
            machine.message("InsertMoney is only valid for CASH mode. Current payment: " + machine.getPayment().name());
            return;
        }
        if (amount <= 0) {
            machine.message("Insert a positive amount.");
            return;
        }

        // Convert to paise and store as double for simplicity
        machine.incrementAmount(amount);
        machine.setState(new MoneyInsertedState());
        machine.message("Balance: ₹" + machine.format(machine.getCurrentAmount()));
    }

    @Override
    public void selectProduct(VendingMachine machine, int rackNumber) {
        machine.setSelectedRack(rackNumber);
        Rack rack = machine.safeGetRack(rackNumber);
        machine.message("Selected " + rack.getProduct().getName() +
                " @ ₹" + rack.getProduct().getPrice() +
                ". " + (machine.getPayment() instanceof CashPayment
                ? "Insert cash to proceed."
                : "Tap CONFIRM to pay by card."));
        if (!(machine.getPayment() instanceof CashPayment)) {
            // Card path: try to vend immediately via auth/capture
            machine.setState(new MoneyInsertedState()); // reuse checks
            machine.selectProduct(rackNumber);          // will proceed
        }
    }
}