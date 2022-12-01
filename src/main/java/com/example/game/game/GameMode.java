package com.example.game.game;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameMode {
    private int mode = 1;
    private static int n = 4;
    private final int numOfMode = 4;
    private final String path = "/com/example/game/images/";
    Image tinyMode = new Image(getClass().getResourceAsStream(path+"tiny.png"));
    Image classicMode = new Image(getClass().getResourceAsStream(path+"classic.png"));
    Image largeMode = new Image(getClass().getResourceAsStream(path+"large.png"));
    Image hugeMode = new Image(getClass().getResourceAsStream(path+"huge.png"));

    public static int getN() {
        return n;
    }

    public void nextMode() {
        mode = (mode + 1) % numOfMode;
    }

    public void prevMode() {
        mode = (mode - 1) % numOfMode;
    }

    public void changeImage(ImageView imageView, Label label) {
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
