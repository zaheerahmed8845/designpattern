package org.example.entity.seat;

import org.example.enums.SeatStatus;

public abstract class Seat {
    private String seatNo;
    private SeatStatus status = SeatStatus.AVAILABLE;
    private double rate;

    public Seat(String seatNo, double rate) {
        this.seatNo = seatNo;
        this.rate = rate;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String v) {
        seatNo = v;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus s) {
        status = s;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double r) {
        rate = r;
    }

    public boolean isAvailable() {
        return status == SeatStatus.AVAILABLE;
    }
}
