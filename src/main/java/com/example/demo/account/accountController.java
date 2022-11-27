package com.example.demo.account;

import com.example.demo.menu.menuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import static java.util.Objects.isNull;

public class accountController {
    @FXML TextField usernameField;
    private Stage primaryStage;
    private Scene menuScene;
    private Parent menuRoot;
    private static Account user = null;

    public static Account getUser() {
        return user;
    }

    public static void setUser(Account user) {
        accountController.user = user;
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        //if account created successfully then proceed to Menu
        if (checkAccount()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/GUI/menu.fxml"));
            menuRoot = loader.load();
            //set username and score
            menuController menu = loader.getController();
            menu.setUsernameLabel(user.getUsername());
            menu.setHighScoreLabel(user.getScore());

            //switch to menu
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            menuScene = new Scene(menuRoot);
            primaryStage.setScene(menuScene);
            menuScene.getStylesheets().add(this.getClass().getResource("/com/example/demo/styling/default.css").toExternalForm());
            menuScene.getStylesheets().add(getClass().getResource("/com/example/demo/styling/style.css").toExternalForm());
            primaryStage.setFullScreen(true);
            primaryStage.show();
        }
    }

    private boolean checkAccount() throws IOException {
        String username = usernameField.getText();
        if(Account.usernameIsValid(username)) {
            if (isNull(Account.accountExist(username))){
                setUser(Account.makeNewAccount(username));
                Account.writeFile(username+".0\n");
            }else {
                setUser(Account.accountExist(username));
            }
            return true;
        }
        return false;
    }

    public void clearField(ActionEvent actionEvent) {
        usernameField.setText("");
    }
}
