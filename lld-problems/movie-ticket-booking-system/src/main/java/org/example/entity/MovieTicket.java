package org.example.entity;

import org.example.entity.seat.Seat;

public class MovieTicket {
    private int ticketId;
    private Seat seat;
    private Movie movie;
    private ShowTime show;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int v) {
        ticketId = v;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat v) {
        seat = v;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie v) {
        movie = v;
    }

    public ShowTime getShow() {
        return show;
    }

    public void setShow(ShowTime v) {
        show = v;
    }
}

