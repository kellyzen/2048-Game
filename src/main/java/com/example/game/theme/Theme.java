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
public class Theme implements ITheme{
    private static final String path = "/com/example/game/styling/";
    private static String theme = path + "default.css";
    private static final String[] themeNames = {"Dark", "Light", "Fantasy", "Nymph", "Default"};
    private final String[] themeFiles = {"dark.css", "light.css", "fantasy.css", "nymph.css", "default.css"};
    public static String[] getThemeNames() {
        return themeNames;
    }

    /**
     *
     * Get theme pathway from resource file.
     *
     * @return int theme pathway
     */
    public static String getTheme() {
        return theme;
    }

    /**
     *
     * Change theme css path based on player's choice from dropdown.
     *
     * @param newTheme name of new theme
     *
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

    /**
     *
     * Add selected theme css to the current root.
     *
     * @param node theme choice box value
     * @param themeFile file name of the theme selected
     *
     */
    public void addTheme(ChoiceBox<String> node, String themeFile) {
        node.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/game/styling/" + themeFile).toString());
    }

    /**
     *
     * Remove specific theme css on the current root.
     *
     * @param node theme choice box value
     * @param themeFile file name of the theme selected
     *
     */
    private void removeTheme(ChoiceBox<String> node, String themeFile) {
        node.getScene().getRoot().getStylesheets().remove(getClass().getResource("/com/example/game/styling/" + themeFile).toString());
    }

    /**
     *
     * Remove all theme css on the current root when new theme is selected.
     * Call removeTheme().
     *
     * @param node theme choice box value
     *
     */
    public void removeAllTheme(ChoiceBox<String> node) {
        for (String theme : themeFiles) {
            removeTheme(node, theme);
        }
    }

    /**
     *
     * Change overall theme for all scene.
     * Call addTheme() and newTheme();
     *
     * @param themeName name of theme selected
     * @param node theme choice box value
     *
     */
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
}
