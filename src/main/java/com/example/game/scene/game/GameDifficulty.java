package com.example.game.scene.game;

import com.example.game.scene.game.cell.Cell;
import java.util.concurrent.ThreadLocalRandom;

public class GameDifficulty {
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();
    private static boolean difficulty = false;

    public void setDifficulty(boolean difficulty) {
        GameDifficulty.difficulty = difficulty;

    }

    public void changeDifficulty() {
        if (difficulty) {
            for (int i = 0; i < n; i++){
                int randomNumX = ThreadLocalRandom.current().nextInt(0, n);
                int randomNumY = ThreadLocalRandom.current().nextInt(0, n);
                cells[randomNumX][randomNumY].setColorByDifficulty();
            }
        }

    }
}
