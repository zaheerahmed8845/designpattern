package org.example.entity;

import java.time.LocalDateTime;

public class Experience {
    private String title;
    private String company;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;

    public Experience(String title, String company, String location, LocalDateTime startDate,
                      LocalDateTime endDate, String description) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }
}
