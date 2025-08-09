package org.example.entity;

import java.util.Objects;

public class DeliveryPerson {
    private String deliveryPersonId;

    public DeliveryPerson(String deliveryPersonId) {
        this.deliveryPersonId = Objects.requireNonNull(deliveryPersonId);
    }

    public void deliverPackage() {
        // TODO: interact with LockerService to place package
    }

    public void pickupReturn() {
        // TODO: pick up from locker for return
    }

    public void receiveReturnNotification(Notification n) {
        // TODO: notify courier app
        n.send();
    }

    public String getDeliveryPersonId() {
        return deliveryPersonId;
    }
}
