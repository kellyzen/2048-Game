package com.example.game.account;

import com.example.game.menu.MenuController;
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

/**
 *
 * AccountController class.
 * Controller class for account.fxml
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class AccountController {
    @FXML TextField usernameField;
    private static Account user = null;

    /**
     *
     * Get player's account.
     *
     * @return player's Account
     */
    public static Account getUser() {
        return user;
    }

    /**
     *
     * Set player's account.
     *
     * @param user player's account
     */
    public static void setUser(Account user) {
        AccountController.user = user;
    }

    /**
     *
     * Calls checkAccount().
     * Called when submit button is clicked.
     * Switch to menu scene if account created successfully.
     *
     * @param event action event
     */
    public void switchToMenu(ActionEvent event) throws IOException {
        //if account created successfully then proceed to Menu
        if (checkAccount()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/game/GUI/menu.fxml"));
            Parent menuRoot = loader.load();
            //set username and score
            MenuController menu = loader.getController();
            menu.setUsernameLabel(user.getUsername());
            menu.setHighScoreLabel(user.getScore());

            //switch to menu
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene menuScene = new Scene(menuRoot);
            primaryStage.setScene(menuScene);
            menuScene.getStylesheets().add(this.getClass().getResource("/com/example/game/styling/default.css").toExternalForm());
            menuScene.getStylesheets().add(getClass().getResource("/com/example/game/styling/style.css").toExternalForm());
            primaryStage.setFullScreen(true);
            primaryStage.show();
        }
    }

    /**
     *
     * Check if the account exists/created before proceeding to game.
     * If account does not exist then call makeNewAccount().
     * If account existed then set player's username.
     *
     * @return boolean
     */
    private boolean checkAccount() throws IOException {
        String username = usernameField.getText();
        //if username is valid
        if(Username.usernameIsValid(username)) {
            //if account not exist, then create new account and append to txt file
            if (isNull(Account.accountExist(username))){
                setUser(Account.makeNewAccount(username));
                FileHandler.writeFile(username+".0\n");
            }else {
                setUser(Account.accountExist(username));
            }
            return true;
        }
        return false;
    }

    /**
     *
     * Remove all text in usernameField.
     *
     */
    public void clearField() {
        usernameField.setText("");
    }
}
