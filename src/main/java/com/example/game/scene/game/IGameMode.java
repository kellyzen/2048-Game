package com.example.game.scene.game;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * Set and change game mode (3x3, 4x4, 5x5, 6x6).
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public interface IGameMode {
    /**
     *
     * Change game mode and view in menu and game.
     *
     */
    void changeMode(ImageView imageView, Label label);
}
