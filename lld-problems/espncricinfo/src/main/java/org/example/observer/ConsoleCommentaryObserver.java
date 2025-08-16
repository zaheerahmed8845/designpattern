package org.example.observer;

public class ConsoleCommentaryObserver implements MatchObserver {
    @Override
    public void onEvent(MatchEvent event) {
        System.out.println("[COMMENTARY] " + event.kind + " :: " + event.payload);
    }
}
