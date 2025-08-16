package org.example.command;


import org.example.component.FlightReservation;
import org.example.entity.FlightSeat;
import org.example.person.Passenger;

public class AssignSeatCommand implements Command {
    private final FlightReservation reservation;
    private final Passenger passenger;
    private final FlightSeat seat;

    public AssignSeatCommand(FlightReservation reservation, Passenger passenger, FlightSeat seat) {
        this.reservation = reservation;
        this.passenger = passenger;
        this.seat = seat;
    }

    @Override
    public void execute() {
        reservation.assignSeat(passenger, seat);
    }
}
