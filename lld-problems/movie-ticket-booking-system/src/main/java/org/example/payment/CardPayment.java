package org.example.payment;

class CardPayment implements Payment {
    private final String token;

    public CardPayment(String token) {
        this.token = token;
    }

    public boolean make(double amount) { /* call gateway */
        return true;
    }
}
