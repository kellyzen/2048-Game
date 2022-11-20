package com.example.demo.game;

import com.example.demo.game.cell.Cell;

public class GameState {
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();

    /**
     *
     * determine the state of game (win/lose)
     * check if there is empty cell
     * return 1 if there are empty cell
     * return 0 if there are cell with number 2048 (win)
     * return -1 if there are no empty cell available
     *
     * @return int
     */
    public int  haveEmptyCell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;
                if(cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        return -1;
    }

    /**
     *
     * checks whether there are neighbouring tiles with same value
     * either horizontally or vertically
     *
     * @return boolean
     */
    private boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            if (cells[i][j + 1].getNumber() == cells[i][j].getNumber())
                return true;
        }
        return false;
    }

    /**
     *
     * checks whether the tiles can move or not when fulled
     *
     * @return boolean
     */
    public boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
