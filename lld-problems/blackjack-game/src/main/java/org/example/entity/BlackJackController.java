package org.example.entity;

public class BlackJackController {

    public boolean validateAction(String action, Hand hand) {
        if (hand.isBust()) return false;
        if (action == null) return false;
        action = action.toLowerCase();
        return switch (action) {
            case "hit", "stand" -> true;
            // extend with "double","split","surrender" rules later
            default -> false;
        };
    }
}
