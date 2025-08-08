package org.example.entity;

import java.time.LocalDateTime;

public class LibraryCard {
    private String cardNumber;
    private LocalDateTime issued;
    private boolean active;

    public boolean isActive() {
        return active;
    }
}
