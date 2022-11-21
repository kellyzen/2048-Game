package com.example.demo.game;

import com.example.demo.endGame.EndGame;
import com.example.demo.game.cell.Cell;
import com.example.demo.game.cell.CreateRandomCell;
import com.example.demo.game.move.Movable;
import com.example.demo.game.move.MoveFactory;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

/**
 *
 * Shows when the game started.
 *
 *@author Kelly Kai Ling Tan-modified
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */

public class GameScene {
    private static final int HEIGHT = 600;
    private static int n = 6;
    private final static int distanceBetweenCells = 10;
    private static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    private static Cell[][] cells = new Cell[n][n];
    private Group root;

    private static int score = 0;

    /**
     *
     * determine n x n
     *
     * @param number number of cells per row & column
     */
    public static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }

    public static int getN() {
        return n;
    }

    public static Cell[][] getCell() {
        return cells;
    }

    public static double getLENGTH() {
        return LENGTH;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        GameScene.score = score;
    }

    public void startGame(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(750, 100);
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(750, 150);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");

        //randomly add two tiles when start game
        CreateRandomCell newCell = new CreateRandomCell();
        newCell.createNewCell(root);
        newCell.createNewCell(root);

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
            Platform.runLater(() -> {
                int haveEmptyCell;
                MoveFactory directionFactory = new MoveFactory();
                Movable up = directionFactory.getDirection("up");
                Movable down = directionFactory.getDirection("down");
                Movable left = directionFactory.getDirection("left");
                Movable right = directionFactory.getDirection("right");

                switch(key.getCode()) {
                    case UP, W -> {
                        up.move();
                    }
                    case DOWN, S -> {
                        down.move();
                    }
                    case LEFT, A -> {
                        left.move();
                    }
                    case RIGHT, D -> {
                        right.move();
                    }
                }

                switch(key.getCode()) {
                    case UP, DOWN, LEFT, RIGHT, A, W, S, D -> {
                        scoreText.setText(score + "");
                        GameState gameState = new GameState();
                        haveEmptyCell = gameState.haveEmptyCell();
                        if (haveEmptyCell == -1) {
                            if (gameState.canNotMove()) {
                                primaryStage.setScene(endGameScene);

                                EndGame.getSingleInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                                root.getChildren().clear();
                                score = 0;
                            }
                        } else if(haveEmptyCell == 1) {
                            newCell.createNewCell(root);
                        } else if(haveEmptyCell == 0) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("You Win!");
                            alert.setHeaderText("Continue game");
                            alert.setContentText("Do you want to continue game?");

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() != ButtonType.OK){
                                primaryStage.setScene(endGameScene);

                                EndGame.getSingleInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                                root.getChildren().clear();
                                score = 0;
                            }
                        }
                    }
                }
            });
        });
    }
}
