package com.example.game.scene.menu;

import javafx.stage.Stage;

/**
 *
 * Shows after account scene.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class Menu {
    private static Stage primaryStage;

    /**
     *
     * Constructor for Menu
     * set and get stage for MenuController
     *
     * @param primaryStage stage for Menu
     */
    public void menu(Stage primaryStage) {
        this.setPrimaryStage(primaryStage);
    }

    /**
     *
     * Get primary stage from GameApp class
     *
     * @return primary stage in GameApp
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     *
     * Set primary stage for Menu
     *
     * @param primaryStage stage for Menu
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
