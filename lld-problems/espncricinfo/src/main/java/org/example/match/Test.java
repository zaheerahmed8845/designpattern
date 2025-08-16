package org.example.match;

public class Test extends Match {
    public Test() {
        this.totalOvers = 90;
    } // per-day not exact, illustrative

    @Override
    protected void firstInnings() { /* multi-day, follow-on */ }

    @Override
    protected void secondInnings() { /* multi-day */ }

    @Override
    protected boolean tieBreakerNeeded() {
        return false;
    } // draws allowed
}
