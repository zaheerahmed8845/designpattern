package org.example.state;

import org.example.VendingMachine;

public interface State {
    void insertMoney(VendingMachine machine, double amount);

    void selectProduct(VendingMachine machine, int rackNumber);

    default String name() {
        return getClass().getSimpleName();
    }
}
