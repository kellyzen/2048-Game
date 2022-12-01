package com.example.game.theme;

import com.example.game.menu.menuController;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;

/**
 *
 * Theme class.
 * Set overall game theme colour.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class Theme{
    private static final String path = "/com/example/game/styling/";
    private static String theme = path + "default.css";
    private static final String[] themeNames = {"Dark", "Light", "Fantasy", "Nymph", "Default"};
    private final String[] themeFiles = {"dark.css", "light.css", "fantasy.css", "nymph.css", "default.css"};
    public static String[] getThemeNames() {
        return themeNames;
    }
    public static String getTheme() {
        return theme;
    }

    /**
     *
     * Change theme css path based on player's choice from dropdown.
     *
     * @param newTheme name of new theme
     */
    public void newTheme(String newTheme) {
        switch (newTheme) {
            case "Dark" -> {
                theme = path + "dark.css";
            }
            case "Light" -> {
                theme = path + "light.css";
            }
            case "Fantasy" -> {
                theme = path + "fantasy.css";
            }
            case "Nymph" -> {
                theme = path + "nymph.css";
            }
            case "Default" -> {
                theme = path + "default.css";
            }
        }
    }

    public void addTheme(ChoiceBox<String> node, String themeFile) {
        node.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/game/styling/" + themeFile).toString());
    }

    public void changeTheme(String themeName, ChoiceBox<String> node) {
        switch (themeName) {
            case "Dark" -> {
                addTheme(node, "dark.css");
                newTheme("Dark");
            }
            case "Light" -> {
                addTheme(node, "light.css");
                newTheme("Light");
            }
            case "Fantasy" -> {
                addTheme(node, "fantasy.css");
                newTheme("Fantasy");
            }
            case "Nymph" -> {
                addTheme(node, "nymph.css");
                newTheme("Nymph");
            }
            case "Default" -> {
                addTheme(node, "default.css");
                newTheme("Default");
            }
        }
    }

    public void removeAllTheme(ChoiceBox<String> node) {
        for (String theme : themeFiles) {
            removeTheme(node, theme);
        }
    }

    private void removeTheme(ChoiceBox<String> node, String themeFile) {
        node.getScene().getRoot().getStylesheets().remove(getClass().getResource("/com/example/game/styling/" + themeFile).toString());
    }

    public void changeBackgroundScene() {
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
