package com.example.game.rank;

import com.example.game.account.accountController;
import com.example.game.menu.menuController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.Scanner;

public class rankController implements Initializable{
    static String filePath = "src/main/resources/com/example/game/account/account.txt";
    static FileInputStream fileInput;
    Stage primaryStage;
    Scene menuScene;
    Parent menuRoot;

    @FXML
    private TableView<Rank> rankTable;

    @FXML
    private TableColumn<Rank, Long> tHighScore;

    @FXML
    private TableColumn<Rank, String> tUsername;
    static ObservableList<Rank> list = FXCollections.observableArrayList();

    // sort the Rank class by high score in ascending order
    Comparator<Rank> comparator = Comparator.comparingLong(Rank::getHighScore).reversed();

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
    }

    private static void readFile() throws IOException {
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

    public void switchToMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/game/GUI/menu.fxml"));
        menuRoot = loader.load();
        //set username and score
        menuController menu = loader.getController();
        menu.setUsernameLabel(accountController.getUser().getUsername());
        menu.setHighScoreLabel(accountController.getUser().getScore());
        //switch to menu
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        menuScene = new Scene(menuRoot);
        primaryStage.setScene(menuScene);
        menuScene.getStylesheets().add(this.getClass().getResource("/com/example/game/styling/default.css").toExternalForm());
        menuScene.getStylesheets().add(getClass().getResource("/com/example/game/styling/style.css").toExternalForm());
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
