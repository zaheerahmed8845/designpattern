package org.example.observer;

import org.example.match.Match;

public class MatchEvent {
    public enum Kind {RUN, WICKET, OVER_END, MILESTONE, RESULT}

    public Kind kind;
    public Match match;
    public String payload;

    public MatchEvent(Kind kind, Match match, String payload) {
        this.kind = kind;
        this.match = match;
        this.payload = payload;
    }
}
