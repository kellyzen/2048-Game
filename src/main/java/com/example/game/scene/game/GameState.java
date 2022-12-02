package com.example.game.scene.game;

import com.example.game.scene.game.cell.Cell;

/**
 *
 * GameState class.
 * Determine current game status (win/lose/on going).
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class GameState {
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();

    /**
     *
     * Determine the state of game (win/lose).
     * Check if there is empty cell.
     * Return 1 if there is empty cell.
     * Return 0 if there is cell with number 2048 (win).
     * Return -1 if there is no empty cell available (maybe lose).
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
     * Checks whether there is neighbouring cell with same value.
     * Either horizontally or vertically.
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
     * Checks whether the tiles can move when no empty cell.
     * Return true if all tiles cannot move and have no same number nearly.
     * Return false if some tiles have same number nearly.
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
