package com.example.game.rank;

public class Rank {
    private String username;
    private Long highScore;

    public String getUsername() {
        return username;
    }

    public Long getHighScore() {
        return highScore;
    }

    public Rank(String username, Long highScore) {
        this.username = username;
        this.highScore = highScore;
    }
}
