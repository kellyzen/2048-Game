package com.example.game.scene.game.move;

import com.example.game.scene.game.cell.Cell;
import com.example.game.scene.game.GameScene;

/**
 *
 * Checks horizontal or vertical destination is valid.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class ValidDestination {
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();

    /**
     *
     * Checks if horizontal destination is correct.
     * Returns true if horizontal destination is correct.
     * Returns false if horizontal destination is not correct.
     *
     * @param i current row of the tile
     * @param j current column of the tile
     * @param des destination of the tile
     * @param sign moves left (-1) or moves right (+1)
     * @return boolean
     *
     */
    boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0) {
            if (cells[i][des + sign].getNumber() == cells[i][j].getNumber() && !cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * Checks if vertical destination is correct.
     * Returns true if vertical destination is correct.
     * Returns false if vertical destination is not correct.
     *
     * @param i current row of the tile
     * @param j current column of the tile
     * @param des destination of the tile
     * @param sign moves up (-1) or moves down (+1)
     * @return boolean
     *
     */
    boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0)
            if (cells[des + sign][j].getNumber() == cells[i][j].getNumber() && !cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0) {
                return true;
            }
        return false;
    }
}


