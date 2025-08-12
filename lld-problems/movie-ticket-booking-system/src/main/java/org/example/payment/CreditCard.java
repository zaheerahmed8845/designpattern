package org.example.payment;

import org.example.entity.Address;

public class CreditCard extends Payment {
    private String nameOnCard, cardNumber, cvv;
    private Address billingAddress;

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String v) {
        nameOnCard = v;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String v) {
        cardNumber = v;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String v) {
        cvv = v;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address v) {
        billingAddress = v;
    }

    public boolean makePayment() {
        return true;
    }
}