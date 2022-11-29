package com.example.game.components.dialogComponent;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

/**
 *
 * ConfirmationDialog class.
 * Implements DialogComponent interface.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class ConfirmationDialog implements DialogComponent {
    /**
     *
     * Creates new confirmation dialog.
     *
     * @param title dialog title
     * @param header dialog header
     * @param context dialog context
     */
    @Override
    public void createDialog(String title, String header, String context){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.exit(0);
        }
    }
}
