package com.example.game.components.dialogComponent;

/**
 *
 * QuitDialog class.
 * Inherit ConfirmationDialog class.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class QuitDialog extends ConfirmationDialog {
    /**
     *
     * QuitDialog class constructor.
     * Set title, header and context of dialog.
     * Called when player clicks quit button.
     *
     */
    public QuitDialog() {
        String title = "Quit Dialog";
        String header = "Quit from this game";
        String context = "Are you sure?";
        ConfirmationDialog continueButton = new ConfirmationDialog();
        continueButton.createDialog(title, header, context);
    }
}
