package com.example.game.scene.game;

import com.example.game.resource.ResourceDirectory;
import com.example.game.scene.account.Account;
import com.example.game.scene.account.AccountController;
import com.example.game.components.dialogComponent.CongratulationDialog;
import com.example.game.components.textComponent.TextComponent;
import com.example.game.scene.endGame.EndGame;
import com.example.game.scene.game.cell.Cell;
import com.example.game.scene.game.cell.CreateRandomCell;
import com.example.game.scene.game.move.Movable;
import com.example.game.scene.game.move.MoveFactory;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

/**
 *
 * Shows when the game started.
 *
 * @author Kelly Kai Ling Tan-modified
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
    private static long score = 0;

    private static long highestTile = 0;

    /**
     *
     * Set game grid (n x n).
     * Number of cells per row & column.
     *
     * @param number grid number (n)
     */
    public static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }

    /**
     *
     * Get game grid (n x n).
     * Number of cells per row & column.
     *
     * @return int grid number (n)
     */
    public static int getN() {
        return n;
    }

    /**
     *
     * Get cell.
     *
     * @return cell
     */
    public static Cell[][] getCell() {
        return cells;
    }

    /**
     *
     * Get length of cell.
     *
     * @return double length of cell
     */
    public static double getLENGTH() {
        return LENGTH;
    }

    /**
     *
     * Get current game score.
     *
     * @return long game score
     */
    public static long getScore() {
        return score;
    }

    /**
     *
     * Set newest game score.
     *
     * @param score current game score
     */
    public static void setScore(long score) {
        GameScene.score = score;
    }

    /**
     *
     * Get the highest tile achieved.
     *
     * @return highest tile number
     */
    public static long getHighestTile() {
        return highestTile;
    }

    /**
     *
     * Set newest highest tile achieved.
     *
     * @param highestTile highest tile number
     */
    public static void setHighestTile(long highestTile) {
        GameScene.highestTile = highestTile;
    }

    /**
     *
     * Stage game scene.
     * Styled using css styling.
     * Display header text, score, highest tile and instructions.
     * Detects any key events (arrow/AWSD/G keys).
     * Switch to end game scene when game ends.
     *
     * @param gameScene game scene
     * @param root game root
     * @param primaryStage game stage
     * @param endGameScene end game scene
     * @param endGameRoot end game root
     */
    public void startGame(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        gameScene.getStylesheets().add(getClass().getResource(new ResourceDirectory().getResource("css","style")).toExternalForm());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

        //display header text
        Text headerText = new Text("SCORE :");
        new TextComponent(headerText, 650, 100);
        root.getChildren().add(headerText);

        //display game score
        Text scoreText = new Text("0");
        new TextComponent(scoreText, 650, 180);
        root.getChildren().add(scoreText);

        //display header text
        Text headerTileText = new Text("HIGHEST\n"+"TILE :");
        new TextComponent(headerTileText, 650, 300);
        root.getChildren().add(headerTileText);

        //display game score
        Text highestTileText = new Text(String.valueOf(getHighestTile()));
        new TextComponent(highestTileText, 650, 420);
        root.getChildren().add(highestTileText);

        //display instruction text
        Text instructionText = new Text("- Use 'AWSD' or Arrow Keys to move\n"+"- Press 'G' to end game");
        new TextComponent(instructionText, 620, 550);
        instructionText.setFont(Font.font(16));
        root.getChildren().add(instructionText);

        //randomly add two tiles when start game
        CreateRandomCell newCell = new CreateRandomCell();
        long cell1 = newCell.createNewCell(root);
        long cell2 = newCell.createNewCell(root);
        setHighestTile(Math.max(cell1, cell2));

        //set game difficulty
        new GameDifficulty().changeDifficulty();

        //detects any key pressed
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
                        highestTileText.setText(highestTile + "");
                        GameState gameState = new GameState();
                        haveEmptyCell = gameState.haveEmptyCell();
                        if (haveEmptyCell == -1) {
                            if (gameState.canNotMove()) {
                                Account user = AccountController.getUser();
                                if(score > user.getScore()) {
                                    try {
                                        user.updateScore(score);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }

                                primaryStage.setScene(endGameScene);
                                EndGame.getSingleInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score, highestTile);
                                root.getChildren().clear();
                                score = 0;
                            }
                        } else if(haveEmptyCell == 1) {
                            new GameDifficulty().changeDifficulty();
                            newCell.createNewCell(root);
                        } else if(haveEmptyCell == 0) {
                            new CongratulationDialog();
                        }
                    }
                    case G -> {
                        Account user = AccountController.getUser();
                        if(score > user.getScore()) {
                            try {
                                user.updateScore(score);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        primaryStage.setScene(endGameScene);
                        EndGame.getSingleInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score, highestTile);
                        root.getChildren().clear();
                        score = 0;
                    }
                }
            });
        });
    }
}
