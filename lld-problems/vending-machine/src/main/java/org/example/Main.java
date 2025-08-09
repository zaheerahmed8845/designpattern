package org.example;

import org.example.entity.Product;
import org.example.entity.Rack;
import org.example.enums.Denomination;
import org.example.enums.ProductType;
import org.example.observer.DisplayObserver;
import org.example.observer.OpsObserver;
import org.example.strategy.CardPayment;
import org.example.strategy.CashPayment;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = VendingMachine.getInstance();

        // Observers
        vm.addObserver(new DisplayObserver());
        vm.addObserver(new OpsObserver(1));

        // Products & racks
        Product coke = new Product("Coke", 101, 35.0, ProductType.BEVERAGE);
        Product chips = new Product("Chips", 102, 20.0, ProductType.SNACK);

        vm.addRack(new Rack(11, coke, 2));
        vm.addRack(new Rack(12, chips, 1));

        // Load cash float for change (maintenance)
        vm.loadFloat(Denomination.R10, 5); // ₹50
        vm.loadFloat(Denomination.R5, 5);  // ₹25
        vm.loadFloat(Denomination.R2, 5);  // ₹10
        vm.loadFloat(Denomination.R1, 10); // ₹10

        System.out.println("\n== INVENTORY ==");
        vm.showInventory();

        // -------- CASH FLOW (needs change) --------
        System.out.println("\n== CASH PURCHASE: Coke ₹35, insert ₹50 ==");
        vm.setPayment(new CashPayment(vm));
        vm.selectProduct(11);     // select first; message prompts to insert
        vm.insertMoney(20);       // balance 20
        vm.insertMoney(20);       // balance 40
        vm.insertMoney(10);       // balance 50
        vm.selectProduct(11);     // enough -> vend, return ₹15

        // -------- CARD FLOW --------
        System.out.println("\n== CARD PURCHASE: Chips ₹20 ==");
        vm.setPayment(new CardPayment());
        vm.selectProduct(12);     // selects & immediately attempts auth->dispense via state logic

        // Try buying chips again (should be out of stock)
        vm.selectProduct(12);

        System.out.println("\n== DONE ==");
    }
}