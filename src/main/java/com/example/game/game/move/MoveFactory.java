package com.example.game.game.move;

public class MoveFactory {
    public Movable getDirection(String direction) {
        if (direction.equalsIgnoreCase("up")) {
            return new MoveUp();

        } else if (direction.equalsIgnoreCase("down")) {
            return new MoveDown();

        } else if (direction.equalsIgnoreCase("left")) {
            return new MoveLeft();

        } else if (direction.equalsIgnoreCase("right")) {
            return new MoveRight();
        }

        return null;
    }
}
