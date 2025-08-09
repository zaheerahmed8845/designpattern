package org.example.observer;

public class OpsObserver implements MachineObserver {
    private final int lowStockThreshold;

    public OpsObserver(int lowStockThreshold) {
        this.lowStockThreshold = lowStockThreshold;
    }

    @Override
    public void onInventoryChanged(int rack, int qty) {
        if (qty <= lowStockThreshold) {
            System.out.println("[OPS] Rack " + rack + " low. Qty=" + qty);
        }
    }

    @Override
    public void onFault(String message) {
        System.out.println("[OPS] Fault: " + message);
    }
}
