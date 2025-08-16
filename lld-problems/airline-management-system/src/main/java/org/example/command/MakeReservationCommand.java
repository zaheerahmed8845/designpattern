package org.example.command;

import org.example.component.FlightReservation;
import org.example.component.ItineraryBuilder;
import org.example.observer.FlightInstance;

import java.util.UUID;

public class MakeReservationCommand implements Command {
    private final ItineraryBuilder builder;
    private final FlightInstance flightInstance;
    private FlightReservation created;

    public MakeReservationCommand(ItineraryBuilder builder, FlightInstance fi) {
        this.builder = builder;
        this.flightInstance = fi;
    }

    @Override
    public void execute() {
        created = new FlightReservation("R-" + UUID.randomUUID(), flightInstance);
        builder.addReservation(created);
    }

    @Override
    public void undo() {
        if (created != null) created.cancel();
    }

    public FlightReservation getReservation() {
        return created;
    }
}
