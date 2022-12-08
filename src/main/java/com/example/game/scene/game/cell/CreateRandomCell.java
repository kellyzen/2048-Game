package com.example.game.scene.game.cell;

import com.example.game.scene.game.GameScene;
import javafx.scene.Group;
import javafx.scene.text.Text;
import java.util.Random;

/**
 *
 * Set random number (2/4) on new cell.
 * Set random cell position.
 *
 * @author Kelly Kai Ling Tan-modified
 * @version Nov 7, 2022
 * @author Coursework: COMP2042
 *
 */
public class CreateRandomCell implements NewCell{
    private Group root;
    private TextMaker textMaker = TextMaker.getSingleInstance();
    int n = GameScene.getN();
    Cell[][] cells = GameScene.getCell();

    /**
     * Create new cell.
     * Random set new cell's position.
     * Calls randomFillNumber().
     *
     * @param root Game root
     */
    public long createNewCell(Group root) {
        this.root = root;

        Cell[][] emptyCells = new Cell[n][n];
        int a = 0;
        int b = 0;
        int aForBound = 0, bForBound = 0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < n-1) {
                        bForBound=b;
                        b++;

                    } else {
                        aForBound=a;
                        a++;
                        b = 0;
                        if(a==n)
                            break outer;
                    }
                }
            }
        }
        return randomFillNumber(aForBound, bForBound, emptyCells);
    }

    /**
     * Random fill number (2/4) on new cell.
     *
     * @param aForBound x-position of new cell
     * @param bForBound y-position of new cell
     * @param emptyCells cell array
     * @return long random filled number (2/4)
     */
    public long randomFillNumber(int aForBound, int bForBound, Cell[][] emptyCells) {
        Text text;
        Random random = new Random();
        boolean putTwo = random.nextInt() % 2 != 0;
        int xCell, yCell;
        xCell = random.nextInt(aForBound+1);
        yCell = random.nextInt(bForBound+1);
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
            return 2;
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
            return 4;
        }
    }
}
