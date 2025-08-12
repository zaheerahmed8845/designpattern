package org.example.entity.seat;

public class SeatFactory {
    public static Seat create(String type, String seatNo, double rate) {
        return switch (type.toUpperCase()) {
            case "GOLD" -> new Gold(seatNo, rate);
            case "PLATINUM" -> new Platinum(seatNo, rate);
            default -> new Silver(seatNo, rate);
        };
    }
}