package com.example.game.scene.game.move;

/**
 *
 * Get player's moving direction (left/right/up/down).
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class MoveFactory {
    /**
     *
     * Get direction from player from arrow keys/ AWSD key
     * Calls MoveUp() class if direction is up
     * Calls MoveDown() class if direction is down
     * Calls MoveLeft() class if direction is left
     * Calls MoveRight() class if direction is right
     *
     * @param direction left/right/up/down
     */
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
