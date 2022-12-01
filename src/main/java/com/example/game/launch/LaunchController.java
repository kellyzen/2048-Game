package com.example.game.launch;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
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

/**
 *
 * LaunchController class.
 * Controller class for launch.fxml
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class LaunchController implements Initializable {
    private static Stage primaryStage;
    @FXML private ImageView logo;
    @FXML private Label title;
    @FXML private Label credit;
    @FXML private Button playButton;

    /**
     *
     * Set primary stage for launch scene.
     *
     * @param primaryStage stage
     *
     */
    public void launch(Stage primaryStage) {
        LaunchController.primaryStage = primaryStage;
    }

    /**
     *
     * Fade transition for logo, text and button on start game.
     *
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // fade transition
        fadeTransition(logo, 4000);
        fadeTransition(title, 5000);
        fadeTransition(credit, 6000);
        fadeTransition(playButton, 8000);
    }

    /**
     *
     * Set fade transition item
     *
     * @param item Node item to be transitioned
     * @param duration time duration for fade transition
     */
    private void fadeTransition(Node item, double duration) {
        FadeTransition fade = new FadeTransition();
        fade.setNode(item);
        fade.setDuration(Duration.millis(duration));
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    /**
     *
     * Switch to account scene when play button is clicked.
     *
     */
    public void switchToAccount() {
        Parent accountRoot = null;
        try {
            accountRoot = FXMLLoader.load(getClass().getResource("/com/example/game/GUI/account.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene accountScene = new Scene(accountRoot);
        primaryStage.setScene(accountScene);
        accountScene.getStylesheets().add(this.getClass().getResource("/com/example/game/styling/default.css").toExternalForm());
        accountScene.getStylesheets().add(getClass().getResource("/com/example/game/styling/style.css").toExternalForm());
    }
}
