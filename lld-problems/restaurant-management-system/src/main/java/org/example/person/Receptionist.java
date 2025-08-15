package org.example.person;

import org.example.entity.Reservation;
import org.example.entity.Table;

import java.util.List;

public class Receptionist extends Person {
    public boolean confirmAndSaveReservation(Reservation r) {
        return true;
    }

    public List<Table> searchAvailableTables() {
        return List.of();
    }
}
