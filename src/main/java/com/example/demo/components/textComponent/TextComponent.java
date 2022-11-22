package com.example.demo.components.textComponent;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TextComponent {
    public TextComponent(Text text, int left, int top) {
        text.setFill(Color.BLACK);
        text.relocate(left,top);
        text.setFont(Font.font("Tw Cen MT", FontWeight.BOLD, FontPosture.REGULAR, 56));
    }
}
