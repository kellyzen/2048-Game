package com.example.game.scene.game.cell;

import javafx.scene.Group;

/**
 *
 * Create new cell(s) in game.
 *
 * @author Kelly Kai Ling Tan-modified
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public interface NewCell {
    /**
     * Create new cell.
     * Random set new cell's position.
     * Calls randomFillNumber().
     *
     * @param root Game root
     */
    long createNewCell(Group root);

    /**
     * Random fill number (2/4) on new cell.
     *
     * @param aForBound x-position of new cell
     * @param bForBound y-position of new cell
     * @param emptyCells cell array
     * @return long random filled number (2/4)
     */
    long randomFillNumber(int aForBound, int bForBound, Cell[][] emptyCells);
}
