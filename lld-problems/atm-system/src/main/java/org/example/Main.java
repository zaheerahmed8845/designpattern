package org.example;

import org.example.account.BankAccount;
import org.example.account.SavingAccount;
import org.example.entity.ATM;
import org.example.entity.ATMCard;
import org.example.entity.Bank;
import org.example.enums.ATMHolder;
import org.example.factory.HardwareFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // --- Setup bank, account, card ---
        Bank bank = new Bank("SampleBank", "SBIN0001");
        BankAccount acc = new SavingAccount(101, 75000);
        ATMCard card = new ATMCard("4111111111111111", "Zaheer Ahmed", LocalDate.now().plusYears(3), "****");
        bank.registerAccount(acc, card, "1234");

        // --- Initialize ATM singleton with simulated hardware ---
        ATMHolder.INSTANCE.initialize(bank, HardwareFactory.simulated());
        ATM atm = ATMHolder.INSTANCE.get();

        // Script a simple session: insert card -> pin -> select withdraw -> amount
        atm.getKeypad().enqueue("1234"); // PIN
        atm.getKeypad().enqueue("1");    // select withdraw
        atm.getKeypad().enqueue("1000"); // amount
        atm.setPendingCard(card);        // simulate inserting card into slot

        // State flow
        atm.insertCard();        // IdleState.insertCard()
        atm.authenticatePin();   // HasCardState.authenticatePin()
        atm.selectOperation();   // SelectOperationState.selectOperation()
        atm.cashWithdrawal();    // CashWithdrawalState.cashWithdrawal()

        // Another quick session: balance inquiry
        atm.getKeypad().enqueue("1234"); // PIN
        atm.getKeypad().enqueue("2");    // select balance inquiry
        atm.setPendingCard(card);
        atm.insertCard();
        atm.authenticatePin();
        atm.selectOperation();
        atm.displayBalance();

        System.out.println("Demo finished.");
    }
}