package org.example.search;

import org.example.entity.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog {
    private static final Catalog INSTANCE = new Catalog();

    public static Catalog getInstance() {
        return INSTANCE;
    }

    private Catalog() {
    }

    private final List<Movie> movies = new ArrayList<>();

    public void add(Movie m) {
        movies.add(m);
    }

    public List<Movie> all() {
        return movies;
    }

    public List<Movie> searchTitle(String t) {
        return movies.stream().filter(m -> t.equalsIgnoreCase(m.getTitle())).collect(Collectors.toList());
    }

    public List<Movie> searchLanguage(String l) {
        return movies.stream().filter(m -> l.equalsIgnoreCase(m.getLanguage())).collect(Collectors.toList());
    }

    public List<Movie> searchGenre(String g) {
        return movies.stream().filter(m -> g.equalsIgnoreCase(m.getGenre())).collect(Collectors.toList());
    }

    public List<Movie> searchRelease(LocalDate d) {
        return movies.stream().filter(m -> d.equals(m.getReleaseDate())).collect(Collectors.toList());
    }
}
