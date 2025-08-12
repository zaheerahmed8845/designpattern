package org.example.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title, genre, language;
    private LocalDate releaseDate;
    private Duration duration;
    private final List<ShowTime> shows = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String v) {
        title = v;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String v) {
        genre = v;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String v) {
        language = v;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate v) {
        releaseDate = v;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration v) {
        duration = v;
    }

    public List<ShowTime> getShows() {
        return shows;
    }
}
