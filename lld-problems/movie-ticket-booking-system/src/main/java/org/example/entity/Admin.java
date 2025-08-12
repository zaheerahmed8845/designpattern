package org.example.entity;

public class Admin extends Person {
    public boolean addMovie(Movie m) { /*repo*/
        return true;
    }

    public boolean updateMovie(Movie m) {
        return true;
    }

    public boolean deleteMovie(Movie m) {
        return true;
    }

    public boolean addShow(ShowTime s) {
        return true;
    }

    public boolean updateShow(ShowTime s) {
        return true;
    }

    public boolean addHall(Cinema c, Hall h) {
        return true;
    }
}
