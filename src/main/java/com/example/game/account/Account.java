package com.example.game.account;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Account class.
 * Saves/create player's account.
 * Saves player's new high score.
 *
 * @author Kelly Kai Ling Tan-modified
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class Account{
    private long score = 0;
    private String username;
    private static ArrayList<Account> accounts = new ArrayList<>();

    /**
     *
     * Account class constructor.
     * Create/get account from unique username.
     *
     * @param username player's username
     */
    public Account(String username) throws FileNotFoundException {
        this.username =username;
    }

    /**
     *
     * Set player's high score.
     *
     * @param score high score
     */
    public void setScore(long score) {
        this.score = score;
    }

    /**
     *
     * Get player's high score.
     *
     * @return long high score
     */
    public long getScore() {
        return score;
    }

    /**
     *
     * Get player's username.
     *
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * Update player's new high score in file (account.txt).
     *
     * @param newScore new high score
     */
    public void updateScore(long newScore) throws IOException {
        setScore(newScore);
        FileHandler.updateFile(accounts);
    }

    /**
     *
     * Check if the account exists or not based on username.
     * Check username from the file (account.txt).
     * If there is same username, return the account.
     * If there is no existing username, return null.
     *
     * @param username player's username
     * @return Account
     */
    public static Account accountExist(String username) throws IOException {
        FileHandler.readFile(accounts);
        for(Account account : accounts){
            if(account.getUsername().equals(username)){
                return account;
            }
        }
        return null;
    }

    /**
     *
     * Create new account for new username.
     * Adds the account to the arraylist of Account (accounts).
     *
     * @param username player's username
     * @return Account
     */
    static Account makeNewAccount(String username) throws FileNotFoundException {
        Account account = new Account(username);
        accounts.add(account);
        return account;
    }

}