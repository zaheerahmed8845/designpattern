package org.example.entity;

import java.time.LocalDateTime;

public class Achievement {
    private String title;
    private LocalDateTime dateAwarded = LocalDateTime.now();
    private String description;

    public Achievement(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
