package org.example;

import org.example.entity.*;

public class Main {
    public static void main(String[] args) {
        var view = new BlackJackGameView();
        var controller = new BlackJackController();
        var shoe = new Shoe(4);
        var dealer = new Dealer("d1", "pass", new Person("Dealer", "", "", "", ""));
        var player = new BlackjackPlayer("p1", "pass", 1_000, new Person("Zaheer", "", "", "", ""));

        var game = new BlackJackGame(player, dealer, shoe, view, controller);

        player.placeBet(100);
        game.startRound();          // Shuffling -> Dealing -> (PlayersTurn or Settlement)
        game.onPlayerAction("hit"); // try a couple of actions
        game.onPlayerAction("stand");
        // Settlement prints results
    }
}
