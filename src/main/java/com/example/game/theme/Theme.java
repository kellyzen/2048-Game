package com.example.game.theme;

import javafx.scene.paint.Color;

public class Theme{
    private static String theme = "/com/example/game/styling/default.css";
    public static String getTheme() {
        return theme;
    }

    public void newTheme(String newTheme) {
        switch (newTheme) {
            case "Dark" -> {
                theme = "/com/example/game/styling/dark.css";
            }
            case "Light" -> {
                theme = "/com/example/game/styling/light.css";
            }
            case "Fantasy" -> {
                theme = "/com/example/game/styling/fantasy.css";
            }
            case "Nymph" -> {
                theme = "/com/example/game/styling/nymph.css";
            }
            case "Default" -> {
                theme = "/com/example/game/styling/default.css";
            }
        }
    }
}
