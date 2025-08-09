package org.example.entity;

public class BlackJackGameView {

    public void showHands(BlackjackPlayer player, Dealer dealer, boolean revealDealerHole) {
        System.out.println("\n--- Current Hands ---");
        System.out.println("Player: " + player.getPerson().getName() + " -> " + player.getHand());
        if (revealDealerHole) {
            System.out.println("Dealer: " + dealer.getPerson().getName() + " -> " + dealer.getHand());
        } else {
            var dealerHand = dealer.getHand();
            if (dealerHand.getCards().size() > 0) {
                var up = dealerHand.getCards().get(0);
                System.out.println("Dealer: " + dealer.getPerson().getName() + " -> [" + up + ", HIDDEN]");
            } else {
                System.out.println("Dealer: " + dealer.getPerson().getName() + " -> []");
            }
        }
    }

    public void showHands(boolean revealDealerHole, BlackjackPlayer p, Dealer d) {
        showHands(p, d, revealDealerHole);
    }

    public void showResults(String message) {
        System.out.println(message);
    }

    public void prompt(String msg) {
        System.out.println(msg);
    }
}
