package org.example.entity;

import org.example.account.BankAccount;
import org.example.enums.TransactionType;

public final class Transaction {
    public final TransactionType type;
    public final BankAccount source;
    public final BankAccount dest;
    public final double amount;
    public final String auditId;

    private Transaction(Builder b) {
        this.type = b.type;
        this.source = b.source;
        this.dest = b.dest;
        this.amount = b.amount;
        this.auditId = b.auditId;
    }

    public static class Builder {
        private TransactionType type;
        private BankAccount source, dest;
        private double amount;
        private String auditId;

        public Builder type(TransactionType t) {
            this.type = t;
            return this;
        }

        public Builder source(BankAccount a) {
            this.source = a;
            return this;
        }

        public Builder dest(BankAccount a) {
            this.dest = a;
            return this;
        }

        public Builder amount(double amt) {
            this.amount = amt;
            return this;
        }

        public Builder audit(String id) {
            this.auditId = id;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
