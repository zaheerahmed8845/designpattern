package org.example.entity;

public final class BillingService {
    private static final BillingService INSTANCE = new BillingService();

    private BillingService() {
    }

    public static BillingService getInstance() {
        return INSTANCE;
    }

    public Bill prepareBill(Bill bill) {
        // place for discounts, coupons, taxes, service charges, etc.
        return bill;
    }
}