package com.example.game.theme;

import com.example.game.scene.menu.MenuController;
import javafx.scene.paint.Color;

/**
 *
 * BackgroundScene class.
 * Set game background colour based on theme chosen.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class BackgroundScene implements IBackgroundScene{
    private static final String path = "/com/example/game/styling/";

    /**
     *
     * Change background scene colour for all scene when a theme is selected.
     *
     * @param theme theme name
     *
     */
    public void changeBackgroundScene(String theme) {
        switch(theme){
            case path+"dark.css" -> {
                MenuController.setBackgroundScene(Color.web("#373e43"));
            }
            case path+"light.css" -> {
                MenuController.setBackgroundScene(Color.web("#eee"));
            }
            case path+"fantasy.css" -> {
                MenuController.setBackgroundScene(Color.web("#D6B9F3"));
            }
            case path+"nymph.css" -> {
                MenuController.setBackgroundScene(Color.web("#5c9aaf"));
            }
            case path+"default.css" -> {
                MenuController.setBackgroundScene(Color.rgb(189, 177, 92));
            }
        }
    }
}
