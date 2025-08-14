package org.example.strategy;

public class CheckPayment extends AbstractPaymentProcessor {
    private final String bankName, checkNumber;

    public CheckPayment(String bankName, String checkNumber) {
        this.bankName = bankName;
        this.checkNumber = checkNumber;
    }

    @Override
    protected boolean doCharge(double amount) {
        return true; /* clear check async */
    }
}
