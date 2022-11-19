package com.example.demo.game;

public class Movement {
    Cell[][] cells = GameScene.getCell();
    ValidDestination validDes = new ValidDestination();

    void moveHorizontally(int i, int j, int des, int sign) {
        if (validDes.isValidDesH(i, j, des, sign)) {
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);
        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }
    void moveVertically(int i, int j, int des, int sign) {
        if (validDes.isValidDesV(i, j, des, sign)) {
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }
}
