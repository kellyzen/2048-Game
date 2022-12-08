package com.example.game.scene.rank;

/**
 *
 * Set and display player's username  and high score
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class Rank {
    private String username;
    private Long highScore;

    /**
     *
     * Get player's username
     *
     * @return String player's username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * Get player's high score.
     *
     * @return long player's high score
     */
    public Long getHighScore() {
        return highScore;
    }

    /**
     *
     * Rank class constructor.
     * Set player's username and high score.
     *
     * @param username player's username
     * @param highScore player's high score
     */
    public Rank(String username, Long highScore) {
        this.username = username;
        this.highScore = highScore;
    }
}
