package com.example.demo;

import com.example.demo.launch.launchController;
import com.example.demo.menu.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

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
    static final int WIDTH = 900;
    static final int HEIGHT = 600;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    private static Scanner input= new Scanner(System.in);

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            //Group menuRoot = new Group();
            //Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
            //Group accountRoot = new Group();
            //Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
            //Group getAccountRoot = new Group();
            //Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
            //Group endgameRoot = new Group();
            //Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
            //Group rankRoot = new Group();
            //Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));

            //stage Menu class
            Menu menu = new Menu();
            menu.menu(primaryStage);

            //launch game scene
            launchController launch = new launchController();
            launch.launch(primaryStage);
            Parent launchRoot = FXMLLoader.load(getClass().getResource("/com/example/demo/GUI/launch.fxml"));
            Scene launchScene = new Scene(launchRoot);
            primaryStage.setScene(launchScene);

            //start account scene
            /*Parent accountRoot = FXMLLoader.load(getClass().getResource("/com/example/demo/GUI/account.fxml"));
            Scene accountScene = new Scene(accountRoot);
            primaryStage.setScene(accountScene);
            accountScene.getStylesheets().add(this.getClass().getResource("/com/example/demo/styling/default.css").toExternalForm());
            accountScene.getStylesheets().add(getClass().getResource("/com/example/demo/styling/style.css").toExternalForm());*/


            //set title, full screen and non-resizable
            primaryStage.setTitle("2048 Game");
            primaryStage.setResizable(false);

            //set icon
            Image icon = new Image(getClass().getResourceAsStream("/com/example/demo/images/icon.png"));
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
