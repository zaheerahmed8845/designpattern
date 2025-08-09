package org.example.state;

import org.example.VendingMachine;

public class DispenseState implements State {
    @Override
    public void insertMoney(VendingMachine m, double amount) {
        m.message("Please wait, dispensing in progress.");
    }

    @Override
    public void selectProduct(VendingMachine m, int rackNumber) {
        m.message("Please wait, dispensing in progress.");
    }
}
