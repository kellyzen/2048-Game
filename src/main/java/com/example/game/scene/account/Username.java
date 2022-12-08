package com.example.game.scene.account;

import com.example.game.components.dialogComponent.WarningDialog;

/**
 *
 * Check player's username before start game.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class Username {
    /**
     *
     * Check if player's username is valid.
     * Check username from player's input text field (usernameField).
     * If username is valid, return true.
     * If username is not valid, return false.
     *
     * @param username player's username
     * @return boolean
     *
     */
    public static boolean usernameIsValid(String username) {
        // return true if the length of username is > 2 or <=15
        if (checkUsernameLength(username)){
            if(!checkUsernameBlankSpace(username)){
                usernameInvalidDialog("Username should not contain space(s)");
                return false;
            }
            if(!checkUsernameCharacter(username)){
                usernameInvalidDialog("Username must contain letters or digits only");
                return false;
            }
            return true;
        }
        // return false if the length of username is <= 2 or >15
        else {
            usernameInvalidDialog("Username must be more than 2 and less than 15 characters");
            return false;
        }
    }

    /**
     *
     * Check if username's length is valid.
     * Return true if length < 15 and > 2.
     * Return false if length > 16 and < 3.
     *
     * @param username player's username
     * @return boolean
     *
     */
    public static boolean checkUsernameLength(String username) {
        return username.length() < 15 && username.length() > 2;
    }

    /**
     *
     * Check if username's contain blank space.
     * Return true if username don't have blank space.
     * Return false if username have blank space.
     *
     * @param username player's username
     * @return boolean
     *
     */
    public static boolean checkUsernameBlankSpace(String username) {
        for (int i = 0; i < username.length(); i++) {
            if (Character.isWhitespace(username.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * Check if username's contain only letter or digit.
     * Return true if username contain only letter or digit.
     * Return false if username contain special character.
     *
     * @param username player's username
     * @return boolean
     *
     */
    public static boolean checkUsernameCharacter(String username) {
        for (int i = 0; i < username.length(); i++) {
            if (!Character.isLetterOrDigit(username.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * If username is not valid, warning dialog will pop out.
     * Warning dialog informs the player on their relative mistake.
     *
     * @param context context of warning dialog
     */
    public static void usernameInvalidDialog(String context) {
        WarningDialog warningDialog = new WarningDialog();
        warningDialog.createDialog("Warning Dialog", "Invalid username", context);
    }
}
