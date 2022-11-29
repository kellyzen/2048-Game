package com.example.game.theme;

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
    private static String theme = "/com/example/game/styling/default.css";
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
