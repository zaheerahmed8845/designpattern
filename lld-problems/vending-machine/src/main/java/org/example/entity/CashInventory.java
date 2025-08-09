package org.example.entity;

import org.example.enums.Denomination;

import java.util.EnumMap;
import java.util.Map;

public class CashInventory {
    private final Map<Denomination, Integer> counts = new EnumMap<>(Denomination.class);

    public CashInventory() {
        for (Denomination d : Denomination.values()) counts.put(d, 0);
    }

    public synchronized void add(Denomination d, int qty) {
        counts.put(d, counts.get(d) + qty);
    }

    public synchronized boolean take(Denomination d, int qty) {
        int have = counts.get(d);
        if (have < qty) return false;
        counts.put(d, have - qty);
        return true;
    }

    public synchronized int get(Denomination d) {
        return counts.get(d);
    }

    public synchronized int totalPaise() {
        int sum = 0;
        for (var e : counts.entrySet()) sum += e.getKey().value * e.getValue();
        return sum;
    }

    public synchronized Map<Denomination, Integer> snapshot() {
        return new EnumMap<>(counts);
    }
}
