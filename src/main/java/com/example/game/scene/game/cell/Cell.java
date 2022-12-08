package com.example.game.scene.game.cell;

import com.example.game.scene.game.GameScene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * Represents an individual cell in the game.
 * Set an integer value and color to each cell which will be changed when combined.
 *
 * @author Kelly Kai Ling Tan-modified
 * @version Nov 7, 2022
 * @author Coursework: COMP2042
 *
 */
public class Cell {
    private Rectangle rectangle;
    private Group root;
    private Text textClass;
    private boolean modify = false;

    /**
     *
     * Set modify value (true or false).
     * If true then allow to modify.
     * If false then not allow to modify.
     *
     * @param modify true false
     */
    public void setModify(boolean modify) {
        this.modify = modify;
    }

    /**
     *
     * Get modify value (true or false).
     *
     * @return boolean modify
     */
    public boolean getModify() {
        return modify;
    }

    /**
     *
     * Get cell's x-position (horizontal).
     *
     * @return double x-position
     */
    double getX() {
        return rectangle.getX();
    }

    /**
     *
     * Get cell's y-position (vertical).
     *
     * @return double y-position
     */
    double getY() {
        return rectangle.getY();
    }

    /**
     *
     * Get cell's number.
     * Parse integer to textClass.
     *
     * @return int current cell's number
     */
    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    /**
     *
     * Get current text of the cell.
     *
     * @return text class
     */
    private Text getTextClass() {
        return textClass;
    }

    /**
     *
     * Set new text for the cell.
     *
     * @param textClass text number of the cell
     */
    void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

    /**
     *
     * Cell class constructor.
     * Set height, width, color and allocate cell's position
     *
     * @param x x-position of cell
     * @param y y-position of cell
     * @param scale height & width of cell
     * @param root game root
     */
    public Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        this.root = root;
        rectangle.setFill(Color.rgb(224, 226, 226, 0.3));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }

    /**
     *
     * Change cell when moved.
     * Call changeTwoText() when two cells merged.
     * Add value of two cells and change the textClass.
     * Set new colour for the cell based on text.
     *
     * @param cell cell to be changed
     *
     */
    public void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);

        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    /**
     *
     * Add two integer values of the merging cells.
     * Add the merged cell value to score.
     * Update the highest tile number.
     *
     * @param cell cell to be added/ combined
     *
     */
    public void adder(Cell cell) {
        //update score
        long score = GameScene.getScore();
        long newTile = cell.getNumber() + this.getNumber();
        score += newTile;
        GameScene.setScore(score);

        //update the highest tile number
        long highestTile = GameScene.getHighestTile();
        GameScene.setHighestTile(Math.max(newTile, highestTile));

        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }

    /**
     *
     * set a color value to each cell based on its current integer value
     *
     * @param number current integer value of the cell
     *
     */
    void setColorByNumber(int number) {
        switch (number) {
            case 0 -> rectangle.setFill(Color.rgb(224, 226, 226, 0.3));
            case 2 -> rectangle.setFill(Color.rgb(232, 250, 150, 0.3));
            case 4 -> rectangle.setFill(Color.rgb(232, 250, 100, 0.5));
            case 8 -> rectangle.setFill(Color.rgb(232, 220, 50, 0.5));
            case 16 -> rectangle.setFill(Color.rgb(232, 170, 44, 0.5));
            case 32 -> rectangle.setFill(Color.rgb(180, 120, 44, 0.5));
            case 64 -> rectangle.setFill(Color.rgb(180, 100, 44, 0.5));
            case 128 -> rectangle.setFill(Color.rgb(180, 80, 44, 0.5));
            case 256 -> rectangle.setFill(Color.rgb(180, 60, 44, 0.5));
            case 512 -> rectangle.setFill(Color.rgb(180, 40, 44, 0.3));
            case 1024 -> rectangle.setFill(Color.rgb(250, 20, 44, 0.3));
            case 2048 -> rectangle.setFill(Color.rgb(250, 10, 44, 0.3));
            default -> rectangle.setFill(Color.rgb(250, 0, 0, 0.3));
        }
    }

    public void setColorByDifficulty() {
        rectangle.setFill(Color.rgb(250, 250, 250, 1));
    }

}
