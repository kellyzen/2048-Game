package com.example.game.account;

import com.example.game.components.dialogComponent.WarningDialog;

/**
 *
 * Username class.
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
     */
    public static boolean usernameIsValid(String username) {
        // return true if the length of username is > 2 or <=15
        if (username.length()<15 && username.length()>2){
            for (int i = 0; i < username.length(); i++) {
                // return false if the character is a white space
                if (Character.isWhitespace(username.charAt(i))) {
                    usernameInvalidDialog("Username should not contain space(s)");
                    return false;
                }
                // return false if the character is neither a letter nor a digit
                if (!Character.isLetterOrDigit(username.charAt(i))) {
                    usernameInvalidDialog("Username must contain letters or digits only");
                    return false;
                }
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
     * If username is not valid, warning dialog will pop out.
     * Warning dialog informs the player on their relative mistake.
     *
     * @param context context of warning dialog
     */
    private static void usernameInvalidDialog(String context) {
        WarningDialog warningDialog = new WarningDialog();
        warningDialog.createDialog("Warning Dialog", "Invalid username", context);
    }
}
