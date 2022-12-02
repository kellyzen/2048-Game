package com.example.game.scene.game.move;

import com.example.game.scene.game.cell.Cell;
import com.example.game.scene.game.GameScene;

/**
 *
 * MoveRight class.
 * Implements Movable interface.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class MoveRight implements Movable {
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();
    Movement movement = new Movement();

    /**
     *
     * Called when clicked 'd' or right arrow key.
     * All cells in the board moves right.
     * Calls moveHorizontally() and passDestination().
     */
    @Override
    public void move() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                movement.moveHorizontally(i, j, passDestination(i, j), 1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    /**
     *
     * Change the position of cell rightward.
     *
     * @param i row
     * @param j column
     * @return int coordinate
     */
    private int passDestination(int i, int j) {
        int coordinate = j;
        for (int k = j + 1; k <= n - 1; k++) {
            if (cells[i][k].getNumber() != 0) {
                coordinate = k - 1;
                break;
            } else if (k == n - 1) {
                coordinate = n - 1;
            }
        }
        return coordinate;
    }
}
