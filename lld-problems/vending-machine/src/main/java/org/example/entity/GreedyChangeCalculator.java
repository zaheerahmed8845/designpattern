package org.example.entity;

import org.example.enums.Denomination;
import org.example.exception.InsufficientChangeException;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class GreedyChangeCalculator implements ChangeCalculator {
    @Override
    public Map<Denomination, Integer> calculate(int changeDue, CashInventory inv)
            throws InsufficientChangeException {

        Map<Denomination, Integer> result = new EnumMap<>(Denomination.class);
        int remaining = changeDue;

        // Sort denominations high -> low
        Denomination[] denoms = Denomination.values();
        Arrays.sort(denoms, (a, b) -> Integer.compare(b.value, a.value));

        for (Denomination d : denoms) {
            int maxNeeded = remaining / d.value;
            if (maxNeeded <= 0) continue;
            int use = Math.min(maxNeeded, inv.get(d));
            if (use > 0) {
                result.put(d, use);
                remaining -= use * d.value;
            }
        }
        if (remaining != 0) throw new InsufficientChangeException("Cannot make exact change");
        return result;
    }
}
