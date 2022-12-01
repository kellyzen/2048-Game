package com.example.game.game;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * GameMode class.
 * Change the game mode.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class GameMode {
    private int mode = 1;
    private static int n = 4;
    private final int numOfMode = 4;
    private final String path = "/com/example/game/images/";
    Image tinyMode = new Image(getClass().getResourceAsStream(path+"tiny.png"));
    Image classicMode = new Image(getClass().getResourceAsStream(path+"classic.png"));
    Image largeMode = new Image(getClass().getResourceAsStream(path+"large.png"));
    Image hugeMode = new Image(getClass().getResourceAsStream(path+"huge.png"));

    /**
     *
     * Get number of grid(n).
     *
     * @return int number of grid(n)
     */
    public static int getN() {
        return n;
    }

    /**
     *
     * Triggered when next (>) button is clicked.
     * Increase mode value by 1 to change to next game mode.
     *
     */
    public void nextMode() {
        mode = (mode + 1) % numOfMode;
    }

    /**
     *
     * Triggered when next (<) button is clicked.
     * Decrease mode value by 1 to change to previous game mode.
     *
     */
    public void prevMode() {
        mode = (mode - 1) % numOfMode;
    }

    /**
     *
     * Triggered when next or previous (<) button is clicked.
     * Change image and label for the game mode.
     * Set number of grid(n).
     *
     * @param imageView Image for game mode
     * @param label Label name for game mode
     *
     */
    public void changeMode(ImageView imageView, Label label) {
        switch (mode) {
            case 0 -> {
                imageView.setImage(tinyMode);
                label.setText("Tiny (3x3)");
                n = 3;
            }
            case 1, -3 -> {
                imageView.setImage(classicMode);
                label.setText("Classic (4x4)");
                n = 4;
            }
            case 2, -2 -> {
                imageView.setImage(largeMode);
                label.setText("Large (5x5)");
                n = 5;
            }
            case 3, -1 -> {
                imageView.setImage(hugeMode);
                label.setText("Huge (6x6)");
                n = 6;
            }
        }
    }

}
