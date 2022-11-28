package com.example.game.account;

import com.example.game.components.dialogComponent.WarningDialog;

public class Username {
    public static boolean usernameIsValid(String username) {
        // return true if the length of username is > 2 or <=15
        if (username.length()<15 && username.length()>2){
            for (int i = 0; i < username.length(); i++) {
                // return false if the character is a white space
                if (Character.isWhitespace(username.charAt(i))) {
                    WarningDialog warningDialog = new WarningDialog();
                    warningDialog.createDialog("Warning Dialog", "Invalid username", "Username should not contain space(s)");
                    return false;
                }
                // return false if the character is neither a letter nor a digit
                if (!Character.isLetterOrDigit(username.charAt(i))) {
                    WarningDialog warningDialog = new WarningDialog();
                    warningDialog.createDialog("Warning Dialog", "Invalid username", "Username must contain letters or digits only");
                    return false;
                }
            }
            return true;
        }
        // return false if the length of username is <= 2 or >15
        else {
            WarningDialog warningDialog = new WarningDialog();
            warningDialog.createDialog("Warning Dialog", "Invalid username", "Username must be more than 2 and less than 15 characters");
            return false;
        }
    }
}
