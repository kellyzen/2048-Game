package com.example.game.components.buttonComponent;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ButtonComponent{

    public ButtonComponent(Button button, int left, int top) {
        button.setPrefSize(170,43);
        button.setTextFill(Color.BLACK);
        button.setFont(Font.font(19));
        button.relocate(left,top);
    }
}
