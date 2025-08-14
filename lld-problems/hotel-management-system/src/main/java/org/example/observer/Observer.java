package org.example.observer;

import org.example.entity.RoomBookingEvent;

public interface Observer {
    void update(RoomBookingEvent event);
}
