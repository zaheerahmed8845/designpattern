package org.example.seat;

public class SilverSeat extends Seat {
    public SilverSeat(String id, String lbl, double r) {
        super(id, lbl, r);
    }

    public String type() {
        return "SILVER";
    }
}

