package org.example.seat;

class PlatinumSeat extends Seat {
    public PlatinumSeat(String id, String lbl, double r) {
        super(id, lbl, r);
    }

    public String type() {
        return "PLATINUM";
    }
}

