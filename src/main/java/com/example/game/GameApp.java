package com.example.game;

import com.example.game.components.dialogComponent.QuitDialog;
import com.example.game.resource.ResourceDirectory;
import com.example.game.scene.launch.LaunchController;
import com.example.game.scene.menu.Menu;
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
            Parent launchRoot = FXMLLoader.load(getClass().getResource(new ResourceDirectory().getResource("fxml","launch")));
            Scene launchScene = new Scene(launchRoot);
            primaryStage.setScene(launchScene);

            //set title and non-resizable screen
            primaryStage.setTitle("2048 Game");
            primaryStage.setResizable(false);

            //set icon
            Image icon = new Image(getClass().getResourceAsStream(new ResourceDirectory().getResource("png","icon")));
            primaryStage.getIcons().add(icon);

            primaryStage.show();

            //close window
            primaryStage.setOnCloseRequest(event -> {
                event.consume();
                new QuitDialog();
            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
