package org.example.payment;

class CashPayment implements Payment {
    public boolean make(double amount) {
        return true;
    }
}
