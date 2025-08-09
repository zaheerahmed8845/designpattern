package org.example.entity;

import org.example.enums.Denomination;
import org.example.exception.InsufficientChangeException;

import java.util.Map;

public interface ChangeCalculator {
    Map<Denomination, Integer> calculate(int changeDuePaise, CashInventory inv) throws InsufficientChangeException;
}
