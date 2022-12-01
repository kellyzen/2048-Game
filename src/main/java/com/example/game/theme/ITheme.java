package com.example.game.theme;

import javafx.scene.control.ChoiceBox;

/**
 *
 * Theme interface.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public interface ITheme {
    /**
     *
     * Change theme css path based on player's choice from dropdown.
     *
     * @param newTheme name of new theme
     *
     */
    void newTheme(String newTheme);
    /**
     *
     * Add selected theme css to the current root.
     *
     * @param node theme choice box value
     * @param themeFile file name of the theme selected
     *
     */
    void addTheme(ChoiceBox<String> node, String themeFile);
    /**
     *
     * Remove all theme css on the current root when new theme is selected.
     * Call removeTheme().
     *
     * @param node theme choice box value
     *
     */
    void removeAllTheme(ChoiceBox<String> node);
    /**
     *
     * Change overall theme for all scene.
     * Call addTheme() and newTheme();
     *
     * @param themeName name of theme selected
     * @param node theme choice box value
     *
     */
    void changeTheme(String themeName, ChoiceBox<String> node);
}
