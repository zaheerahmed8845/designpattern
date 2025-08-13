package org.example.entity;

import org.example.account.BankAccount;
import org.example.device.*;
import org.example.enums.ATMStatus;
import org.example.event.AtmEvent;
import org.example.factory.HardwareFactory;
import org.example.state.ATMState;
import org.example.state.IdleState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class ATM {
    private ATMState currentATMState;
    private ATMStatus atmStatus = ATMStatus.Idle;
    private int atmBalance = 100000; // simulated cash
    private int noOfHundredDollarBills = 500;
    private int noOfFiftyDollarBills = 200;
    private int noOfTwentyDollarBills = 300;
    private final CardReader cardReader;
    private final CashDispenser cashDispenser;
    private final Keypad keypad;
    private final Screen screen;
    private final Printer printer;
    private Bank bank;
    private ATMCard currentCard;
    private BankAccount currentAccount;
    private ATMCard pendingCard;
    private final List<Consumer<AtmEvent>> listeners = new ArrayList<>();

    public ATM(Bank bank, HardwareFactory factory) {
        this.bank = Objects.requireNonNull(bank);
        this.cardReader = factory.createCardReader(this);
        this.keypad = factory.createKeypad();
        this.screen = factory.createScreen();
        this.printer = factory.createPrinter();
        this.cashDispenser = factory.createCashDispenser(this);
        initializeATM();
    }

    public void on(Consumer<AtmEvent> l) {
        listeners.add(l);
    }

    public void emit(String type, String msg) {
        var ev = new AtmEvent(type, msg);
        for (var l : listeners) l.accept(ev);
    }

    public void initializeATM() {
        this.currentATMState = new IdleState(this);
        this.atmStatus = ATMStatus.Idle;
        checkLimits();
    }

    public void checkLimits() { /* verify cassette totals */ }

    public void displayCurrentState() {
        screen.showMessage("ATM State: " + currentATMState.getClass().getSimpleName());
    }

    public void setState(ATMState next) {
        this.currentATMState = next;
    }

    public void setStatus(ATMStatus status) {
        this.atmStatus = status;
    }

    // delegate to state
    public void insertCard() {
        currentATMState.insertCard();
    }

    public void authenticatePin() {
        currentATMState.authenticatePin();
    }

    public void selectOperation() {
        currentATMState.selectOperation();
    }

    public void cashWithdrawal() {
        currentATMState.cashWithdrawal();
    }

    public void displayBalance() {
        currentATMState.displayBalance();
    }

    public void changePIN() {
        currentATMState.changePIN();
    }

    public void transferMoney() {
        currentATMState.transferMoney();
    }

    public void cancelTransaction() {
        currentATMState.cancelTransaction();
    }

    public void returnCard() {
        if (currentCard != null) {
            screen.showMessage("Returning card...");
            currentCard = null;
            currentAccount = null;
        }
        setStatus(ATMStatus.Idle);
        setState(new IdleState(this));
    }

    public boolean authenticatePin(String pinInput) {
        if (currentCard == null) return false;
        return bank.verifyPin(currentCard.cardNumber(), pinInput);
    }

    public boolean changePin(String newPin) {
        if (currentCard == null) return false;
        return bank.updatePin(currentCard.cardNumber(), newPin);
    }

    public boolean hasCash(double amount) {
        return atmBalance >= amount;
    }

    public void debitATMBalance(double amount) {
        atmBalance -= (int) amount;
    }

    public void onCardRead(ATMCard card, BankAccount account) {
        this.currentCard = card;
        this.currentAccount = account;
    }

    // Helpers for simulation
    public void setPendingCard(ATMCard card) {
        this.pendingCard = card;
    }

    public ATMCard getPendingCard() {
        return pendingCard;
    }

    // Getters
    public CardReader getCardReader() {
        return cardReader;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public Keypad getKeypad() {
        return keypad;
    }

    public Screen getScreen() {
        return screen;
    }

    public Printer getPrinter() {
        return printer;
    }

    public Bank getBank() {
        return bank;
    }

    public BankAccount getCurrentAccount() {
        return currentAccount;
    }
}
