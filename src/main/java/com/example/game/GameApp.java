package com.example.game;

import com.example.game.launch.LaunchController;
import com.example.game.menu.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * 2048 Game
 *
 * @author Kelly Kai Ling Tan-modified
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */

public class GameApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            //stage Menu class
            Menu menu = new Menu();
            menu.menu(primaryStage);

            //launch game scene
            LaunchController launch = new LaunchController();
            launch.launch(primaryStage);
            Parent launchRoot = FXMLLoader.load(getClass().getResource("/com/example/game/GUI/launch.fxml"));
            Scene launchScene = new Scene(launchRoot);
            primaryStage.setScene(launchScene);

            //set title and non-resizable screen
            primaryStage.setTitle("2048 Game");
            primaryStage.setResizable(false);

            //set icon
            Image icon = new Image(getClass().getResourceAsStream("/com/example/game/images/icon.png"));
            primaryStage.getIcons().add(icon);

            primaryStage.show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
