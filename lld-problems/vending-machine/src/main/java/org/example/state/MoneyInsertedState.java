package org.example.state;

import org.example.VendingMachine;
import org.example.entity.Rack;
import org.example.strategy.CashPayment;

public class MoneyInsertedState implements State {

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        if (!(machine.getPayment() instanceof CashPayment)) {
            machine.message("InsertMoney is only valid for CASH mode.");
            return;
        }
        if (amount <= 0) {
            machine.message("Insert a positive amount.");
            return;
        }
        machine.incrementAmount(amount);
        machine.message("Balance: ₹" + machine.format(machine.getCurrentAmount()));
    }

    @Override
    public void selectProduct(VendingMachine machine, int rackNumber) {
        machine.setSelectedRack(rackNumber);

        Rack rack = machine.safeGetRack(rackNumber);
        if (rack.isEmpty()) {
            machine.message("Rack " + rackNumber + " is empty. Choose another item or refund.");
            return;
        }

        double price = rack.getProduct().getPrice();
        // Authorization uses payment strategy (cash/card)
        if (!machine.getPayment().authorize(price)) {
            machine.message("Price is ₹" + machine.format(price) +
                    ". Current balance ₹" + machine.format(machine.getCurrentAmount()));
            return;
        }

        // Enough funds (or card authorized) → move to dispense
        machine.setState(new DispenseState());
        machine.dispenseProduct();
    }
}
