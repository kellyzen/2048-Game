package com.example.game.components.dialogComponent;

/**
 *
 * DialogComponent interface.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public interface DialogComponent {
    /**
     *
     * Creates new dialog.
     *
     * @param title dialog title
     * @param header dialog header
     * @param context dialog context
     */
    void createDialog(String title, String header, String context);
}
