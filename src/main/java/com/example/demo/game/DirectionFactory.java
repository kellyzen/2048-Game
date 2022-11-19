package com.example.demo.game;

public class DirectionFactory {
    public Direction getDirection(String direction) {
        if (direction.equalsIgnoreCase("up")) {
            return new Up();

        } else if (direction.equalsIgnoreCase("down")) {
            return new Down();

        } else if (direction.equalsIgnoreCase("left")) {
            return new Left();

        } else if (direction.equalsIgnoreCase("right")) {
            return new Right();
        }

        return null;
    }
}
