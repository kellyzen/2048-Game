package com.example.game.scene.game.cell;

import com.example.game.scene.game.GameScene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * TextMaker class.
 * Create text with specific font attributes and color.
 *
 * @author Kelly Kai Ling Tan-modified
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */

public class TextMaker {
    private static TextMaker singleInstance = null;

    /**
     *
     * Constructor for TextMaker class.
     *
     */
    private TextMaker() {

    }

    /**
     *
     * Singleton design pattern for text maker.
     *
     */
    public static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    /**
     *
     * Create new text with specific font attributes and color.
     *
     * @param input string text to be created
     * @param xCell x-position of the cell
     * @param yCell y-position of the cell
     * @param root group root
     * @return Text
     *
     */
    Text madeText(String input, double xCell, double yCell, Group root) {
        double length = GameScene.getLENGTH();
        double fontSize = (3 * length) / 7.0;
        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (1.2)* length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.rgb(250, 250, 250, 0.7));
        return text;
    }

    /**
     *
     * Exchange two cell's text values.
     *
     * @param first first text value
     * @param second second text value
     *
     */
    static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);

    }

}
