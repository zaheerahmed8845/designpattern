package org.example.person;

import org.example.entity.Cinema;
import org.example.entity.Hall;
import org.example.entity.Movie;
import org.example.entity.ShowTime;

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
