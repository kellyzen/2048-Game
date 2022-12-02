package com.example.game.scene.game.cell;

import javafx.scene.Group;

public interface NewCell {
    long createNewCell(Group root);
    long randomFillNumber(int aForBound, int bForBound, Cell[][] emptyCells);
}
