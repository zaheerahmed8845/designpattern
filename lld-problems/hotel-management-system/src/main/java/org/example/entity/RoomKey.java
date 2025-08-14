package org.example.entity;

public class RoomKey {
    public String keyId, barcode;
    public boolean isActive, isMaster;

    public boolean assign(Room room) {
        return true;
    }
}
