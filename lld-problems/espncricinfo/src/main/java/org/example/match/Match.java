package org.example.match;

import org.example.entity.*;
import org.example.observer.MatchEvent;
import org.example.observer.MatchEventSource;
import org.example.observer.MatchObserver;
import org.example.stats.MatchStat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Match implements MatchEventSource {
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public int totalOvers; // per innings
    public Team home;
    public Team away;
    public Stadium stadium;
    public List<Umpire> umpires = new ArrayList<>();
    public Playing11 playingHome = new Playing11();
    public Playing11 playingAway = new Playing11();
    public List<Inning> innings = new ArrayList<>();
    public MatchStat matchStat = new MatchStat();

    private final List<MatchObserver> observers = new ArrayList<>();

    // Observer plumbing
    @Override
    public void register(MatchObserver obs) {
        observers.add(obs);
    }

    @Override
    public void unregister(MatchObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyAllObservers(MatchEvent ev) {
        observers.forEach(o -> o.onEvent(ev));
    }

    public void assignUmpire(Umpire u) {
        umpires.add(u);
    }

    // Template Method: define common flow; subclasses customize hooks
    public final void playMatch() {
        preMatch();
        toss();
        firstInnings();
        intervalHook();
        secondInnings();
        if (tieBreakerNeeded()) superOverOrReserveDay();
        finalizeResult();
        postMatch();
    }

    private void intervalHook() {
    }

    protected void preMatch() {
    }

    protected void toss() {
    }

    protected abstract void firstInnings();

    protected abstract void secondInnings();

    protected boolean tieBreakerNeeded() {
        return false;
    }

    protected void superOverOrReserveDay() {
    }

    protected void finalizeResult() {
    }

    protected void postMatch() {
    }
}
