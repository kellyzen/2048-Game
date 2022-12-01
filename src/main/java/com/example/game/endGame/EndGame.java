package com.example.game.endGame;

import com.example.game.account.Account;
import com.example.game.account.accountController;
import com.example.game.components.buttonComponent.ButtonComponent;
import com.example.game.components.dialogComponent.QuitDialog;
import com.example.game.components.textComponent.TextComponent;
import com.example.game.menu.Menu;
import com.example.game.menu.menuController;
import com.example.game.theme.Theme;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * EndGame class.
 *
 * @author Kelly Kai Ling Tan-modified
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class EndGame {
    private static EndGame singleInstance = null;
    private EndGame(){
    }
    /**
     *
     * Singleton design pattern for end game.
     *
     */
    public static EndGame getSingleInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    /**
     *
     * Shows when the game ended.
     * Display game score and highest tile.
     * Display back to menu button and quit game button.
     * Either directs back to menu or quit game.
     *
     * @param endGameScene end game scene
     * @param root end game root
     * @param primaryStage current stage
     * @param score score of the game played
     * @param highestTile highest tile achieved
     *
     */
    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage,long score, long highestTile){
        //set full screen and add css styling
        primaryStage.setFullScreen(true);
        endGameScene.getStylesheets().add(getClass().getResource("/com/example/game/styling/style.css").toExternalForm());

        //display header text
        Text headerText = new Text("GAME OVER");
        new TextComponent(headerText, 250, 200);
        root.getChildren().add(headerText);

        //display game score
        Text scoreText = new Text("Score: \n"+score+"");
        new TextComponent(scoreText, 250, 280);
        root.getChildren().add(scoreText);
        scoreText.setFont(Font.font(36));

        //display the highest tile
        Text highestTileText = new Text("Highest Tile: \n"+highestTile+"");
        new TextComponent(highestTileText, 450, 280);
        root.getChildren().add(highestTileText);
        highestTileText.setFont(Font.font(36));

        //display quit button
        Button quitButton = new Button("Quit");
        new ButtonComponent(quitButton, 250, 400);
        root.getChildren().add(quitButton);

        //display back to menu button
        Button menuButton = new Button("Back To Menu");
        new ButtonComponent(menuButton, 450, 400);
        root.getChildren().add(menuButton);

        //quit game dialog pop up when quit button is clicked
        quitButton.setOnMouseClicked(event -> new QuitDialog());

        //direct back to menu page when menu button is clicked
        menuButton.setOnMouseClicked(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Menu menu = new Menu();
                menu.menu(primaryStage);
                Parent menuRoot = null;
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/game/GUI/menu.fxml"));
                    menuRoot = loader.load();
                    //set username and score
                    menuController menuController = loader.getController();
                    Account user = accountController.getUser();
                    menuController.setUsernameLabel(user.getUsername());
                    menuController.setHighScoreLabel(user.getScore());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Scene menuScene = new Scene(menuRoot);
                primaryStage.setScene(menuScene);
                String themePath = Theme.getTheme();
                menuRoot.getStylesheets().add(getClass().getResource(themePath).toString());
                primaryStage.setFullScreen(true);
            }
        });
    }
}