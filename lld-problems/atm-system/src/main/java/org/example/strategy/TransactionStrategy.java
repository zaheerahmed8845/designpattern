package org.example.strategy;

import org.example.entity.ATM;

public interface TransactionStrategy {
    boolean execute(ATM atm) throws Exception;

    String name();
}
