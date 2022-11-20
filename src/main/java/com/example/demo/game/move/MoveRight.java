package com.example.demo.game.move;

import com.example.demo.game.cell.Cell;
import com.example.demo.game.GameScene;

public class MoveRight implements Movable {
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();
    Movement movement = new Movement();

    /**
     *
     * called when clicked 'd' or right arrow keyboard
     * all cells in the board moves right
     * calls moveHorizontally
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
     * change the position of cell rightward
     *
     * @param i row
     * @param j column
     * @return int
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
