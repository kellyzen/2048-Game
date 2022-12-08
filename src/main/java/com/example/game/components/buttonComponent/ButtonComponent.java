package com.example.game.components.buttonComponent;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * Style for all button's component.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class ButtonComponent{
    /**
     *
     * ButtonComponent class constructor.
     * Set size, text fill, font style and relocate button.
     *
     * @param button button to be styled
     * @param left location from left in px
     * @param top location from top in px
     */
    public ButtonComponent(Button button, int left, int top) {
        button.setPrefSize(170,43);
        button.setTextFill(Color.BLACK);
        button.setFont(Font.font(19));
        button.relocate(left,top);
    }
}
