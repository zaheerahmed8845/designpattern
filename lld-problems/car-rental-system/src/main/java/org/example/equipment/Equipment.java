package org.example.equipment;

public abstract class Equipment {
    private int equipmentId;
    private int price;

    public Equipment(int equipmentId, int price) {
        this.equipmentId = equipmentId;
        this.price = price;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public int getPrice() {
        return price;
    }
}
