package org.example.seat;

public class GoldSeat extends Seat {
    public GoldSeat(String id, String lbl, double r) {
        super(id, lbl, r);
    }

    public String type() {
        return "GOLD";
    }
}
