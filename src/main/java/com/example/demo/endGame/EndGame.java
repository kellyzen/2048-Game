package com.example.demo.endGame;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Optional;

/**
 *
 * Shows when the game ended either game over or won.
 * Directs back to menu or quit game.
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
    public static EndGame getSingleInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    /**
     *
     * create new text with specific font attributes and color
     *
     * @param endGameScene current scene
     * @param root group root
     * @param primaryStage current stage
     * @param score current score of the game
     *
     */
    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage,long score){
        primaryStage.setFullScreen(true);

        Text text = new Text("GAME OVER");
        text.relocate(250,250);
        text.setFont(Font.font(56));
        root.getChildren().add(text);

        Text scoreText = new Text(score+"");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(250,350);
        scoreText.setFont(Font.font(56));
        root.getChildren().add(scoreText);

        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(100,30);
        quitButton.setTextFill(Color.PINK);
        root.getChildren().add(quitButton);
        quitButton.relocate(250,450);
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    root.getChildren().clear();
                    System.exit(0);
                }
            }
        });
    }
}
