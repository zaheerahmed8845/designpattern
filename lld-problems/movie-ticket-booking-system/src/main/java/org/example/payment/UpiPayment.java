package org.example.payment;

class UpiPayment implements Payment {
    private final String handle;

    public UpiPayment(String handle) {
        this.handle = handle;
    }

    public boolean make(double amount) {
        return true;
    }
}
