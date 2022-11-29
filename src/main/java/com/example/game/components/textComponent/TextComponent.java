package com.example.game.components.textComponent;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * TextComponent class.
 * Style for all text's component.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class TextComponent {
    /**
     *
     * TextComponent class constructor.
     * Set text fill, font style and relocate button.
     *
     * @param text text to be styled
     * @param left location from left in px
     * @param top location from top in px
     */
    public TextComponent(Text text, int left, int top) {
        text.setFill(Color.BLACK);
        text.relocate(left,top);
        text.setFont(Font.font("Tw Cen MT", FontWeight.BOLD, FontPosture.REGULAR, 56));
    }
}
