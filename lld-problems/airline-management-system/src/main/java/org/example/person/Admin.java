package org.example.person;

import org.example.entity.Airport;
import org.example.entity.Flight;
import org.example.enums.AccountStatus;
import org.example.observer.FlightInstance;

public class Admin extends Person {
    public Admin(String name, String email, String phone) {
        super(name, email, phone);
    }

    public boolean addAirport(Airport a) {
        return true;
    }

    public boolean addFlight(Flight f) {
        return true;
    }

    public boolean assignCrew(FlightInstance fi, Crew crew) {
        return true;
    }

    public boolean blockUser(Customer c) {
        c.account.status = AccountStatus.BLOCKED;
        return true;
    }

    public boolean unblockUser(Customer c) {
        c.account.status = AccountStatus.ACTIVE;
        return true;
    }
}
