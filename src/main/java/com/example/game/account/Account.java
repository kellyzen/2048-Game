package com.example.game.account;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Saves user's account.
 * Checks and compares the high score of users.
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

    public Account(String username) throws FileNotFoundException {
        this.username =username;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getScore() {
        return score;
    }

    public String getUsername() {
        return username;
    }

    public void updateScore(long newScore) throws IOException {
        setScore(newScore);
        FileHandler.updateFile(accounts);
    }

    public static Account accountExist(String username) throws IOException {
        FileHandler.readFile(accounts);
        for(Account account : accounts){
            if(account.getUsername().equals(username)){
                return account;
            }
        }
        return null;
    }

    static Account makeNewAccount(String username) throws FileNotFoundException {
        Account account = new Account(username);
        accounts.add(account);
        return account;
    }

}
