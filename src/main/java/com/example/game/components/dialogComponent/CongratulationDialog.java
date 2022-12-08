package com.example.game.components.dialogComponent;

/**
 *
 * Display congratulation messages.
 * Inherit ConfirmationDialog class.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class CongratulationDialog extends ConfirmationDialog {
    /**
     *
     * CongratulationDialog class constructor.
     * Set title, header and context of dialog.
     * Called when player reached 2048 in game.
     *
     */
    public CongratulationDialog() {
        String title = "Information Dialog";
        String header = "Congratulations, you've reached 2048!";
        String context = "Click 'OK' if you wish to exit game\nClick 'Cancel' if you wish to continue game";
        ConfirmationDialog continueButton = new ConfirmationDialog();
        continueButton.createDialog(title, header, context);
    }
}
