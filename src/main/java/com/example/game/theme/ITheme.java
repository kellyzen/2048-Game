package com.example.game.theme;

import javafx.scene.control.ChoiceBox;

public interface ITheme {
    void newTheme(String newTheme);
    void addTheme(ChoiceBox<String> node, String themeFile);
    void removeAllTheme(ChoiceBox<String> node);
    void changeTheme(String themeName, ChoiceBox<String> node);
}
