package com.example.game.scene.game;

/**
 *
 * IGameDifficulty interface.
 * Set and change game difficulty.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public interface IGameDifficulty {
    /**
     *
     * Set difficulty to true or false based on input parameter.
     *
     * @param difficulty boolean
     */
    void setDifficulty(boolean difficulty);

    /**
     *
     * Change difficulty level in game if toggle switch is on (true).
     *
     */
    void changeDifficulty();
}
