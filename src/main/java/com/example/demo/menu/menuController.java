package com.example.demo.menu;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import com.example.demo.game.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        GameScene.setN(n);
        game.startGame(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);

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

        switch (theme) {
            case "Dark" -> {
                menuChoiceBox.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/demo/styling/dark.css").toString());
                setBackgroundScene(Color.web("#373e43"));
            }
            case "Light" -> {
                menuChoiceBox.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/demo/styling/light.css").toString());
                setBackgroundScene(Color.web("#eee"));
            }
            case "Fantasy" -> {
                menuChoiceBox.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/demo/styling/fantasy.css").toString());
                setBackgroundScene(Color.web("#D6B9F3"));
            }
            case "Nymph" -> {
                menuChoiceBox.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/demo/styling/nymph.css").toString());
                setBackgroundScene(Color.web("#5c9aaf"));
            }
            case "Default" -> {
                menuChoiceBox.getScene().getRoot().getStylesheets().add(getClass().getResource("/com/example/demo/styling/default.css").toString());
                setBackgroundScene(Color.rgb(189, 177, 92));
            }
        }
    }

    private static int mode = 1;
    private static int n = 4;
    @FXML
    ImageView imageView;
    @FXML
    Button nextButton;
    @FXML
    Button prevButton;
    @FXML
    Label modeLabel;

    Image tinyMode = new Image(getClass().getResourceAsStream("/com/example/demo/images/tiny.png"));
    Image classicMode = new Image(getClass().getResourceAsStream("/com/example/demo/images/classic.png"));
    Image largeMode = new Image(getClass().getResourceAsStream("/com/example/demo/images/large.png"));
    Image hugeMode = new Image(getClass().getResourceAsStream("/com/example/demo/images/huge.png"));

    public void nextMode() {
        mode = (mode + 1) % 4;
        changeImage();
    }

    public void prevMode() {
        mode = (mode - 1) % 4;
        changeImage();
    }

    private void changeImage() {
        switch (mode) {
            case 0 -> {
                imageView.setImage(tinyMode);
                modeLabel.setText("Tiny (3x3)");
                n = 3;
            }
            case 1, -3 -> {
                imageView.setImage(classicMode);
                modeLabel.setText("Classic (4x4)");
                n = 4;
            }
            case 2, -2 -> {
                imageView.setImage(largeMode);
                modeLabel.setText("Large (5x5)");
                n = 5;
            }
            case 3, -1 -> {
                imageView.setImage(hugeMode);
                modeLabel.setText("Huge (6x6)");
                n = 6;
            }
        }
    }
}

