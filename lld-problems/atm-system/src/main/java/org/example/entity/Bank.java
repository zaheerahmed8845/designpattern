package org.example.entity;

import org.example.account.BankAccount;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final String name;
    private final String bankCode;
    private final Map<Integer, BankAccount> accounts = new HashMap<>();
    private final Map<String, String> pinByCard = new HashMap<>();
    private final Map<String, Integer> accountByCard = new HashMap<>();

    public Bank(String name, String bankCode) {
        this.name = name;
        this.bankCode = bankCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void registerAccount(BankAccount account, ATMCard card, String pin) {
        accounts.put(account.getAccountNumber(), account);
        pinByCard.put(card.cardNumber(), pin);
        accountByCard.put(card.cardNumber(), account.getAccountNumber());
    }

    public boolean verifyPin(String cardNumber, String pin) {
        return pin.equals(pinByCard.get(cardNumber));
    }

    public boolean updatePin(String cardNumber, String newPin) {
        if (!pinByCard.containsKey(cardNumber)) return false;
        pinByCard.put(cardNumber, newPin);
        return true;
    }

    public BankAccount findAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public BankAccount accountForCard(String cardNumber) {
        Integer accNo = accountByCard.get(cardNumber);
        return accNo == null ? null : accounts.get(accNo);
    }
}
