package org.example;

import org.example.entity.*;
import org.example.state.GameState;
import org.example.state.Settlement;
import org.example.state.Shuffling;

public class BlackJackGame {
    private final BlackjackPlayer player;
    private final Dealer dealer;
    private final Shoe shoe;
    private final BlackJackGameView view;
    private final BlackJackController controller;

    // FSM internals
    private GameState state;
    private boolean turnDone;                 // set after stand or bust
    private final StringBuilder lastResult = new StringBuilder();

    public BlackJackGame(BlackjackPlayer player, Dealer dealer, Shoe shoe,
                         BlackJackGameView view, BlackJackController controller) {
        this.player = player;
        this.dealer = dealer;
        this.shoe = shoe;
        this.view = view;
        this.controller = controller;
    }

    // ======= Public API (incl. diagram compatibility) =======
    public void startRound() {
        transitionTo(new Shuffling());
        drive();
    }

    public void start() {
        startRound();
    }

    public void playAction(String action, Hand hand) {
        onPlayerAction(action);
    }

    public void hit(Hand hand) {
        onPlayerAction("hit");
    }

    public void stand(Hand hand) {
        onPlayerAction("stand");
    }

    public void compareAndSettle() {
        transitionTo(new Settlement());
        drive();
    }

    public void settle() {
        transitionTo(new Settlement());
        drive();
    }

    /**
     * Called by controller/UI when the human chooses an action.
     */
    public void onPlayerAction(String action) {
        applyAction(action);
        drive();
    }

    // ======= FSM plumbing =======
    private void drive() {
        while (true) {
            state.handle(this);
            GameState next = state.next(this);
            if (next.getClass() == state.getClass()) break; // waiting for external input
            transitionTo(next);
        }
    }

    private void transitionTo(GameState next) {
        this.state = next;
        this.state.enter(this);
    }

    // ======= Helpers used by states =======
    public void resetHands() {
        player.getHand().clear();
        dealer.getHand().clear();
        lastResult.setLength(0);
        turnDone = false;
    }

    public void playDealerPolicy() {
        // Stand on all 17s (incl. soft 17) for now
        while (dealer.getHand().getScore() < 17) {
            dealer.getHand().add(shoe.dealCard());
        }
    }

    public void settleAll() {
        view.showHands(true, player, dealer);

        boolean playerBJ = player.getHand().isBlackjack();
        boolean dealerBJ = dealer.getHand().isBlackjack();

        int bet = player.getBet();
        if (bet <= 0) {
            lastResult.append("No bet placed.\n");
            return;
        }

        // Natural blackjacks
        if (playerBJ || dealerBJ) {
            if (playerBJ && dealerBJ) {
                player.payout(bet); // push
                lastResult.append("Both Blackjack. Push. Bet returned.\n");
            } else if (playerBJ) {
                int win = (int) Math.round(bet * 2.5); // 3:2 payout
                player.payout(win);
                lastResult.append("Player Blackjack! Paid ").append(win).append(".\n");
            } else {
                player.loseBet();
                lastResult.append("Dealer Blackjack. Player loses.\n");
            }
            return;
        }

        int p = player.getHand().getScore();
        int d = dealer.getHand().getScore();

        if (player.getHand().isBust()) {
            player.loseBet();
            lastResult.append("Player busts (").append(p).append("). Lose.\n");
            return;
        }
        if (dealer.getHand().isBust()) {
            int win = bet * 2;
            player.payout(win);
            lastResult.append("Dealer busts (").append(d).append("). Player paid ").append(win).append(".\n");
            return;
        }
        if (p > d) {
            int win = bet * 2;
            player.payout(win);
            lastResult.append("Player ").append(p).append(" beats Dealer ").append(d)
                    .append(". Paid ").append(win).append(".\n");
        } else if (p < d) {
            player.loseBet();
            lastResult.append("Dealer ").append(d).append(" beats Player ").append(p).append(". Lose.\n");
        } else {
            player.payout(bet);
            lastResult.append("Push at ").append(p).append(". Bet returned.\n");
        }
    }

    public boolean shuffleNeeded() {
        return shoe.remaining() < 15;
    }

    void applyAction(String action) {
        action = action == null ? "" : action.toLowerCase().trim();
        if (!controller.validateAction(action, player.getHand())) {
            view.showResults("Invalid action: " + action);
            return;
        }
        switch (action) {
            case "hit" -> {
                player.getHand().add(shoe.dealCard());
                view.showHands(false, player, dealer);
                if (player.getHand().isBust()) {
                    view.showResults("Player busts with " + player.getHand().getScore());
                    turnDone = true;
                }
            }
            case "stand" -> {
                turnDone = true;
            }
            default -> view.showResults("Unsupported: " + action);
        }
    }

    // ======= Getters for states/view =======
    public Shoe getShoe() {
        return shoe;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public BlackjackPlayer getPlayer() {
        return player;
    }

    public BlackJackGameView getView() {
        return view;
    }

    // turn flags
    public boolean isTurnDone() {
        return turnDone;
    }

    public void clearTurnDone() {
        turnDone = false;
    }

    public String resultsText() {
        return lastResult.toString();
    }
}
