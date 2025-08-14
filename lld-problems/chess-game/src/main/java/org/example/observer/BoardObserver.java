package org.example.observer;

import org.example.entity.ChessBoard;
import org.example.entity.Move;

public interface BoardObserver {
    void onBoardChanged(ChessBoard board, Move lastMove);
}
