package org.example;

import org.example.entity.ChessBoard;
import org.example.entity.ChessGame;
import org.example.entity.Move;
import org.example.entity.Player;
import org.example.view.ChessGameView;

public class Main {
    public static void main(String[] args) {
        // View subscribes as an Observer
        ChessGameView view = new ChessGameView();

        // Ensure the Singleton board exists and is observable
        ChessBoard board = ChessBoard.getInstance();
        board.addObserver(view);

        Player white = new Player("Zaheer (White)", true);
        Player black = new Player("Bot (Black)", false);

        ChessGame game = new ChessGame(white, black, view);

        // A couple of sample moves using Command via game.playMove (e2e4, e7e5, g1f3)
        game.playMove(4, 1, 4, 3); // white pawn e2->e4
        game.playMove(4, 6, 4, 4); // black pawn e7->e5
        game.playMove(6, 0, 5, 2); // white knight g1->f3

        // Iterate (Iterator pattern) through move history
        System.out.println("Move history:");
        int i = 1;
        for (Move m : game) {
            System.out.printf("%d) %s: (%d,%d)->(%d,%d) %s%n",
                    i++, m.getPlayer().getName(),
                    m.getStart().getX(), m.getStart().getY(),
                    m.getEnd().getX(), m.getEnd().getY(),
                    m.getMoveType());
        }

        // Show current game state per State pattern
        System.out.println("Game status: " + game.getStatus());
    }
}