package org.example.match;

public class ODI extends Match {
    public ODI() {
        this.totalOvers = 50;
    }

    @Override
    protected void firstInnings() { /* 50 overs max */ }

    @Override
    protected void secondInnings() { /* 50 overs + DLS possibility */ }

    @Override
    protected boolean tieBreakerNeeded() {
        return true;
    } // super over possible

    @Override
    protected void superOverOrReserveDay() { /* super over rules */ }
}
