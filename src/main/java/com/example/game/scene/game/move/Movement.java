package com.example.game.scene.game.move;

import com.example.game.scene.game.cell.Cell;
import com.example.game.scene.game.GameScene;

/**
 *
 * Either moves cell horizontally or vertically.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class Movement {
    Cell[][] cells = GameScene.getCell();
    ValidDestination validDes = new ValidDestination();

    /**
     *
     * Moves the cell horizontally if horizontal move is valid.
     *
     * @param i current row of the tile
     * @param j current column of the tile
     * @param des destination of the tile
     * @param sign moves up/left (-1) or moves down/right (+1)
     *
     */
    void moveHorizontally(int i, int j, int des, int sign) {
        if (validDes.isValidDesH(i, j, des, sign)) {
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);
        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }

    /**
     *
     * Moves the cell vertically if vertical move is valid.
     *
     * @param i current row of the tile
     * @param j current column of the tile
     * @param des destination of the tile
     * @param sign moves up/left (-1) or moves down/right (+1)
     *
     */
    void moveVertically(int i, int j, int des, int sign) {
        if (validDes.isValidDesV(i, j, des, sign)) {
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }
}
