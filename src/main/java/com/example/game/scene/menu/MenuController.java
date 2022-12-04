package com.example.game.scene.menu;

import com.example.game.audio.AudioPlayer;
import com.example.game.components.dialogComponent.QuitDialog;
import com.example.game.components.toggleSwitchComponent.ToggleSwitchComponent;
import com.example.game.resource.ResourceDirectory;
import com.example.game.scene.game.GameDifficulty;
import com.example.game.scene.game.GameMode;
import com.example.game.scene.game.GameScene;
import com.example.game.theme.BackgroundScene;
import com.example.game.theme.Theme;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 *
 * MenuController class.
 * Controller class for menu.fxml
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class MenuController implements Initializable {
    static final int WIDTH = 900;
    static final int HEIGHT = 600;
    Stage primaryStage = Menu.getPrimaryStage();
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT);
    private static Color backgroundScene;
    @FXML Label highScoreLabel, usernameLabel, modeLabel;
    @FXML private ChoiceBox<String> menuChoiceBox;
    @FXML ImageView imageView;
    @FXML Button nextButton, prevButton;
    @FXML private Slider volumeSlider;
    @FXML Pane toggleSwitchPane;
    GameMode gameMode = new GameMode();
    private final String[] theme = Theme.getThemeNames();

    /**
     *
     * Set player's username text.
     *
     * @param text username
     */
    public void setUsernameLabel(String text) {
        usernameLabel.setText(text);
    }
    /**
     *
     * Set player's high score label.
     *
     * @param score player's high score
     */
    public void setHighScoreLabel(Long score) {
        highScoreLabel.setText(String.valueOf(score));
    }
    /**
     *
     * Set game scene.
     *
     * @param gameScene game scene
     */
    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }
    /**
     *
     * Get game scene.
     *
     * @return gameScene game scene
     */
    public Scene getGameScene() {
        return gameScene;
    }
    /**
     *
     * Set game root.
     *
     * @param gameRoot game scene
     */
    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }
    /**
     *
     * Set background scene colour.
     *
     * @param backgroundScene background scene
     */
    public static void setBackgroundScene(Color backgroundScene) {
        MenuController.backgroundScene = backgroundScene;
    }

    /**
     *
     * Initialize actions for menuChoiceBox to change theme colour.
     * Initialize actions for volumeSlider to change bgm volume.
     *
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //menuChoiceBox
        menuChoiceBox.setValue(Theme.getCurrentTheme());
        menuChoiceBox.getItems().addAll(theme);
        menuChoiceBox.setOnAction(this::changeTheme);

        //volumeSlider
        volumeSlider.setValue(AudioPlayer.getMediaPlayer().getVolume() * 100);
        volumeSlider.valueProperty().addListener((arg01, arg11, arg2) -> AudioPlayer.getMediaPlayer().setVolume(volumeSlider.getValue() * 0.01));

        //toggleSwitch
        new GameDifficulty().setDifficulty(false);
        ToggleSwitchComponent toggleSwitch = new ToggleSwitchComponent();
        SimpleBooleanProperty toggleOn = toggleSwitch.switchOnProperty();
        toggleOn.addListener((observable, oldValue, newValue) -> {
            new GameDifficulty().setDifficulty(newValue);
        });
        toggleSwitchPane.getChildren().add(toggleSwitch);
    }

    /**
     *
     * Switch to Game Scene when Start Game button clicked.
     *
     */
    public void switchToGame() {
        BackgroundScene backgroundColor = new BackgroundScene();
        String themePath = Theme.getTheme();
        backgroundColor.changeBackgroundScene(themePath);

        //set root and scene for game
        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        gameRoot.getStylesheets().add(getClass().getResource(themePath).toString());
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, backgroundScene);
        setGameScene(gameScene);
        primaryStage.setScene(gameScene);

        //set root and scene for end game
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, backgroundScene);
        endgameRoot.getStylesheets().add(getClass().getResource(themePath).toString());

        //reset game  mode
        gameMode.changeMode(imageView, modeLabel);

        //set grid number (n) and startGame method in GameScene
        GameScene game = new GameScene();
        GameScene.setN(GameMode.getN());
        game.startGame(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);

        //set title and full screen
        primaryStage.setTitle("2048 Game");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    /**
     *
     * Switch to Rank Scene when Rank button clicked.
     *
     */
    public void switchToRank() throws IOException {
        String themePath = Theme.getTheme();
        Parent rankRoot = FXMLLoader.load(getClass().getResource(new ResourceDirectory().getResource("fxml","rank")));
        Scene rankScene = new Scene(rankRoot);
        rankRoot.getStylesheets().add(getClass().getResource(themePath).toString());
        primaryStage.setScene(rankScene);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    /**
     *
     * Switch to Game Scene when Quit Game button clicked.
     *
     */
    public void quitGame() {
        new QuitDialog();
    }

    /**
     *
     * Change theme when menuChoiceBox value is changed.
     *
     */
    public void changeTheme(ActionEvent event) {
        Theme newTheme = new Theme();
        gameScene = getGameScene();
        String theme = menuChoiceBox.getValue();
        newTheme.removeAllTheme(menuChoiceBox);
        newTheme.changeTheme(theme, menuChoiceBox);
        BackgroundScene backgroundColor = new BackgroundScene();
        String themePath = Theme.getTheme();
        backgroundColor.changeBackgroundScene(themePath);
    }

    /**
     *
     * Switch to the next game mode.
     * Change to next mode's image and label.
     *
     */
    public void nextMode() {
        gameMode.nextMode();
        gameMode.changeMode(imageView, modeLabel);
    }

    /**
     *
     * Switch to the previous game mode.
     * Change to previous mode's image and label.
     *
     */
    public void prevMode() {
        gameMode.prevMode();
        gameMode.changeMode(imageView, modeLabel);
    }
}

