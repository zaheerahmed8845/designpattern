package org.example.entity;

import org.example.enums.SeatStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ShowTime {
    private int showId;
    private LocalDateTime startTime, date;
    private int durationMinutes;
    private Movie movie;
    private Hall hall;
    private final Map<String, SeatStatus> seatStatuses = new HashMap<>();

    public int getShowId() {
        return showId;
    }

    public void setShowId(int v) {
        showId = v;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime v) {
        startTime = v;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime v) {
        date = v;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int v) {
        durationMinutes = v;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie v) {
        movie = v;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall v) {
        hall = v;
    }

    public Map<String, SeatStatus> getSeatStatuses() {
        return seatStatuses;
    }
}
