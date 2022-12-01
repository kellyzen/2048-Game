package com.example.game.theme;

import com.example.game.menu.menuController;
import javafx.scene.paint.Color;

public class BackgroundScene {
    private static final String path = "/com/example/game/styling/";

    /**
     *
     * Change background scene colour for all scene when a theme is selected.
     *
     */
    public void changeBackgroundScene(String theme) {
        switch(theme){
            case path+"dark.css" -> {
                menuController.setBackgroundScene(Color.web("#373e43"));
            }
            case path+"light.css" -> {
                menuController.setBackgroundScene(Color.web("#eee"));
            }
            case path+"fantasy.css" -> {
                menuController.setBackgroundScene(Color.web("#D6B9F3"));
            }
            case path+"nymph.css" -> {
                menuController.setBackgroundScene(Color.web("#5c9aaf"));
            }
            case path+"default.css" -> {
                menuController.setBackgroundScene(Color.rgb(189, 177, 92));
            }
        }
    }
}
