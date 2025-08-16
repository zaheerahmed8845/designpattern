package org.example.entity;

import java.time.LocalDateTime;

public class Education {
    private String school;
    private String degree;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Education(String school, String degree, String description, LocalDateTime startDate, LocalDateTime endDate) {
        this.school = school;
        this.degree = degree;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
