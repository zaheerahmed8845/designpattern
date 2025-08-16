package org.example.match;

public class T20 extends Match {
    public T20() {
        this.totalOvers = 20;
    }

    @Override
    protected void firstInnings() { /* 20 overs */ }

    @Override
    protected void secondInnings() { /* 20 overs */ }

    @Override
    protected boolean tieBreakerNeeded() {
        return true;
    }

    @Override
    protected void superOverOrReserveDay() { /* super over */ }
}
