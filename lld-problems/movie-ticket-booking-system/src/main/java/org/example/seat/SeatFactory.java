package org.example.seat;

public class SeatFactory {
    public static Seat create(String type, String id, String label, double baseRate) {
        return switch (type.toUpperCase()) {
            case "GOLD" -> new GoldSeat(id, label, baseRate);
            case "PLATINUM" -> new PlatinumSeat(id, label, baseRate);
            default -> new SilverSeat(id, label, baseRate);
        };
    }
}
