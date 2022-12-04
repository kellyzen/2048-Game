package com.example.game.scene.game;

import com.example.game.scene.game.cell.Cell;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * GameDifficulty class.
 * Implements IGameDifficulty interface.
 * Set and change game difficulty.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class GameDifficulty implements IGameDifficulty {
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();
    private static boolean difficulty = false;

    /**
     *
     * Set difficulty to true or false based on input parameter.
     *
     * @param difficulty boolean
     */
    public void setDifficulty(boolean difficulty) {
        GameDifficulty.difficulty = difficulty;
    }

    /**
     *
     * Change difficulty level in game if toggle switch is on (true).
     *
     */
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
