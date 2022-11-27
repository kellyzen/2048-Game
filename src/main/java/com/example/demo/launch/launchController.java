package com.example.demo.launch;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class launchController implements Initializable {
    private static Stage primaryStage;
    @FXML private ImageView logo;
    @FXML private Label title;
    @FXML private Label credit;
    @FXML private Button playButton;

    public void launch(Stage primaryStage) {
        launchController.primaryStage = primaryStage;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // fade transition
        fadeTransition(logo, 4000);
        fadeTransition(title, 5000);
        fadeTransition(credit, 6000);
        fadeTransition(playButton, 8000);
    }

    private void fadeTransition(Node item, double duration) {
        FadeTransition fade = new FadeTransition();
        fade.setNode(item);
        fade.setDuration(Duration.millis(duration));
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    public void switchToAccount() {
        Parent accountRoot = null;
        try {
            accountRoot = FXMLLoader.load(getClass().getResource("/com/example/demo/GUI/account.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene accountScene = new Scene(accountRoot);
        primaryStage.setScene(accountScene);
        accountScene.getStylesheets().add(this.getClass().getResource("/com/example/demo/styling/default.css").toExternalForm());
        accountScene.getStylesheets().add(getClass().getResource("/com/example/demo/styling/style.css").toExternalForm());
    }
}
