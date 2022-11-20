package com.example.demo.game.move;

import com.example.demo.game.cell.Cell;
import com.example.demo.game.GameScene;

public class MoveUp implements Movable {
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();
    Movement movement = new Movement();

    /**
     *
     * called when clicked 'w' or up arrow keyboard
     * all cells in the board moves upward
     * calls moveVertically
     */
    @Override
    public void move() {
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                movement.moveVertically(i, j, passDestination(i, j), -1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }
    }

    /**
     *
     * change the position of cell upward
     *
     * @param i row
     * @param j column
     * @return int
     */
    private int passDestination(int i, int j) {
        int coordinate = i;
        for (int k = i - 1; k >= 0; k--) {
            if (cells[k][j].getNumber() != 0) {
                coordinate = k + 1;
                break;
            } else if (k == 0) {
                coordinate = 0;
            }
        }
        return coordinate;
    }
}
