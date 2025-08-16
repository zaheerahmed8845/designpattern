package org.example.payment;

public class CreditCard extends Payment {
    public String nameOnCard;
    public String cardNumber;

    public CreditCard(String nameOnCard, String cardNumber, double amount) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.amount = amount;
    }
}