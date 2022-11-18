package com.example.demo.menu;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import com.example.demo.game.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class menuController implements Initializable {
    static final int WIDTH = 900;
    static final int HEIGHT = 600;

    Stage primaryStage = Menu.getPrimaryStage();
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT);

    private Color backgroundScene = Color.rgb(189, 177, 92);
    private static Scanner input= new Scanner(System.in);

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public Scene getGameScene() {
        return gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    public void setBackgroundScene(Color backgroundScene) {
        this.backgroundScene = backgroundScene;
    }

    public void switchToGame(ActionEvent event) throws IOException {

        Group menuRoot = new Group();
        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
        Group accountRoot = new Group();
        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
        Group getAccountRoot = new Group();
        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
        Group rankRoot = new Group();
        Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));



        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, backgroundScene);
        setGameScene(gameScene);
        primaryStage.setScene(gameScene);

        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, backgroundScene);

        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);

        //set title
        primaryStage.setTitle("2048 Game");
        //set full screen
        primaryStage.setFullScreen(true);

        primaryStage.show();
    }

    public void quitGame(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Dialog");
        alert.setHeaderText("Quit from this page");
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.exit(0);
        }
    }

    @FXML
    private ChoiceBox<String> menuChoiceBox;

    private final String[] theme = {"Dark", "Light", "Fantasy", "Nymph", "Default"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        menuChoiceBox.getItems().addAll(theme);
        menuChoiceBox.setOnAction(this::changeTheme);

    }

    public void changeTheme(ActionEvent event) {
        gameScene = getGameScene();

        String theme = menuChoiceBox.getValue();
        menuChoiceBox.getScene().getRoot().getStylesheets().remove(getClass().getResource("/com/example/demo/styling/dark.css").toString());
        menuChoiceBox.getScene().getRoot().getStylesheets().remove(getClass().getResource("/com/example/demo/styling/light.css").toString());
        menuChoiceBox.getScene().getRoot().getStylesheets().remove(getClass().getResource("/com/example/demo/styling/fantasy.css").toString());
        menuChoiceBox.getScene().getRoot().getStylesheets().remove(getClass().getResource("/com/example/demo/styling/nymph.css").toString());
        menuChoiceBox.getScene().getRoot().getStylesheets().remove(getClass().getResource("/com/example/demo/styling/default.css").toString());

        if (Objects.equals(theme, "Dark")) {
            menuChoiceBox.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/demo/styling/dark.css").toString());
            setBackgroundScene(Color.web("#373e43"));

        } else if (Objects.equals(theme, "Light")) {
            menuChoiceBox.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/demo/styling/light.css").toString());
            setBackgroundScene(Color.web("#eee"));

        } else if (Objects.equals(theme, "Fantasy")) {
            menuChoiceBox.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/demo/styling/fantasy.css").toString());
            setBackgroundScene(Color.web("#D6B9F3"));

        } else if (Objects.equals(theme, "Nymph")) {
            menuChoiceBox.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/demo/styling/nymph.css").toString());
            setBackgroundScene(Color.web("#5c9aaf"));

        } else if (Objects.equals(theme, "Default")) {
            menuChoiceBox.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/demo/styling/default.css").toString());
            setBackgroundScene(Color.rgb(189, 177, 92));

        }
    }
}

