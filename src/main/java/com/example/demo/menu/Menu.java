package com.example.demo.menu;

import javafx.stage.Stage;

public class Menu {
    private static Stage primaryStage;

    public void menu(Stage primaryStage) {
        this.setPrimaryStage(primaryStage);
        /*menuController menu = new menuController();
        Account user = accountController.getUser();
        menu.setUsernameLabel(user.getUsername());
        menu.setHighScoreLabel(user.getScore());*/
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
