package org.example.view;

import org.example.entity.Box;
import org.example.entity.ChessBoard;
import org.example.entity.Move;
import org.example.observer.BoardObserver;
import org.example.piece.Piece;

public class ChessGameView implements BoardObserver {
    @Override
    public void onBoardChanged(ChessBoard board, Move lastMove) {
        // simple console view
        for (int y = 7; y >= 0; y--) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < 8; x++) {
                Piece p = board.getBox(x, y).getPiece();
                row.append(p == null ? ".." : p.toString()).append(' ');
            }
            System.out.println(row);
        }
        if (lastMove != null) {
            System.out.printf("Last move: %s -> %s by %s (%s)%n",
                    pos(lastMove.getStart()), pos(lastMove.getEnd()),
                    lastMove.getPlayer().getName(), lastMove.getMoveType());
        }
        System.out.println();
    }

    private String pos(Box b) {
        return "(" + b.getX() + "," + b.getY() + ")";
    }
}
