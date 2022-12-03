package com.example.game.scene.rank;

import com.example.game.resource.ResourceDirectory;
import com.example.game.scene.account.AccountController;
import com.example.game.scene.menu.MenuController;
import com.example.game.theme.Theme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * RankController class.
 * Controller class for rank.fxml
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class RankController implements Initializable{
    static String filePath = new ResourceDirectory().getResource("txt","account");
    static FileInputStream fileInput;
    Stage primaryStage;
    Scene menuScene;
    Parent menuRoot;

    @FXML private TableView<Rank> rankTable;
    @FXML private TableColumn<Rank, Long> tHighScore;
    @FXML private TableColumn<Rank, String> tUsername;
    @FXML Label usernameNo1, highScoreNo1, usernameNo2, highScoreNo2, usernameNo3, highScoreNo3;

    static ObservableList<Rank> list = FXCollections.observableArrayList();

    // sort the Rank class by high score in ascending order
    Comparator<Rank> comparator = Comparator.comparingLong(Rank::getHighScore).reversed();

    /**
     *
     * Read account.txt.
     * Set username and high score column.
     * Display values in rankTable.
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tUsername.setCellValueFactory(new PropertyValueFactory<Rank, String>("username"));
        tHighScore.setCellValueFactory(new PropertyValueFactory<Rank, Long>("highScore"));
        try {
            readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FXCollections.sort(list, comparator);
        rankTable.setItems(list);
        leaderBoard(list);
    }

    private void leaderBoard(ObservableList<Rank> leads) {
        Rank rank1 = leads.get(0);
        usernameNo1.setText(rank1.getUsername());
        highScoreNo1.setText(String.valueOf(rank1.getHighScore()));

        Rank rank2 = leads.get(1);
        usernameNo2.setText(rank2.getUsername());
        highScoreNo2.setText(String.valueOf(rank2.getHighScore()));

        Rank rank3 = leads.get(2);
        usernameNo3.setText(rank3.getUsername());
        highScoreNo3.setText(String.valueOf(rank3.getHighScore()));
    }

    /**
     *
     * Read from file (account.txt) line by line.
     * Set the player's username and high score in Rank class.
     *
     */
    private static void readFile() throws IOException {
        //clear list to prevent duplicate inputs
        list.clear();
        try {
            fileInput = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner =new Scanner(fileInput);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] parts = s.split("\\.");
            list.add(new Rank(parts[0], Long.parseLong(parts[1])));
        }
        scanner.close();
    }

    /**
     *
     * Calls checkAccount().
     * Called when submit button is clicked.
     * Switch to menu scene when button is clicked.
     *
     * @param event action event
     */
    public void switchToMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(new ResourceDirectory().getResource("fxml","menu")));
        menuRoot = loader.load();
        //set username and score
        MenuController menu = loader.getController();
        menu.setUsernameLabel(AccountController.getUser().getUsername());
        menu.setHighScoreLabel(AccountController.getUser().getScore());
        //get current theme
        String themePath = Theme.getTheme();
        //switch to menu
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        menuScene = new Scene(menuRoot);
        primaryStage.setScene(menuScene);
        menuScene.getStylesheets().add(this.getClass().getResource(themePath).toExternalForm());
        menuScene.getStylesheets().add(getClass().getResource(new ResourceDirectory().getResource("css","style")).toExternalForm());
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
