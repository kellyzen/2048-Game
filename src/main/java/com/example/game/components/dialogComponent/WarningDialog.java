package com.example.game.components.dialogComponent;

import javafx.scene.control.Alert;

/**
 *
 * Create w arning dialog.
 * Implements DialogComponent interface.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class WarningDialog implements DialogComponent {
    /**
     *
     * Creates new warning dialog.
     *
     * @param title dialog title
     * @param header dialog header
     * @param context dialog context
     */
    @Override
    public void createDialog(String title, String header, String context){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }
}
