package com.example.demo.game;

public class Left implements Direction{
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();
    Movement movement = new Movement();

    @Override
    public void move() {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                movement.moveHorizontally(i, j, passDestination(i, j), -1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    private int passDestination(int i, int j) {
        int coordinate = j;
        for (int k = j - 1; k >= 0; k--) {
            if (cells[i][k].getNumber() != 0) {
                coordinate = k + 1;
                break;
            } else if (k == 0) {
                coordinate = 0;
            }
        }
        return coordinate;
    }
}
