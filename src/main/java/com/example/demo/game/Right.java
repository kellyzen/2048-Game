package com.example.demo.game;

public class Right implements Direction{
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();
    Movement movement = new Movement();

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
