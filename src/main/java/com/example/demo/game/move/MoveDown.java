package com.example.demo.game.move;

import com.example.demo.game.cell.Cell;
import com.example.demo.game.GameScene;

public class MoveDown implements Movable {
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();
    Movement movement = new Movement();

    /**
     *
     * called when clicked 's' or down arrow keyboard
     * all cells in the board moves downward
     * calls moveVertically
     */
    @Override
    public void move() {
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                movement.moveVertically(i, j, passDestination(i, j), 1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }
    }

    /**
     *
     * change the position of cell downward
     *
     * @param i row
     * @param j column
     * @return int
     */
    private int passDestination(int i, int j) {
        int coordinate = i;
        for (int k = i + 1; k <= n - 1; k++) {
            if (cells[k][j].getNumber() != 0) {
                coordinate = k - 1;
                break;
            } else if (k == n - 1) {
                coordinate = n - 1;
            }
        }
        return coordinate;
    }
}
