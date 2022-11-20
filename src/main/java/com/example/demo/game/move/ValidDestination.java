package com.example.demo.game.move;

import com.example.demo.game.cell.Cell;
import com.example.demo.game.GameScene;

public class ValidDestination {
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();

    /**
     *
     * checks if horizontal destination is correct
     * returns true if horizontal destination is correct
     * returns false if horizontal destination is not correct
     *
     * @param i current row of the tile
     * @param j current column of the tile
     * @param des destination of the tile
     * @param sign moves up/left (-1) or moves down/right (+1)
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
     * checks if vertical destination is correct
     * returns true if vertical destination is correct
     * returns false if vertical destination is not correct
     *
     * @param i current row of the tile
     * @param j current column of the tile
     * @param des destination of the tile
     * @param sign moves up/left (-1) or moves down/right (+1)
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


