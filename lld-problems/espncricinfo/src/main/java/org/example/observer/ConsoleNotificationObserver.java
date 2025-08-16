package org.example.observer;

public class ConsoleNotificationObserver implements MatchObserver {
    @Override
    public void onEvent(MatchEvent event) {
        if (event.kind == MatchEvent.Kind.WICKET || event.kind == MatchEvent.Kind.MILESTONE) {
            System.out.println("[NOTIFY] " + event.payload);
        }
    }
}