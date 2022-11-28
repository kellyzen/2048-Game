package com.example.game.account;

import com.example.game.components.dialogComponent.WarningDialog;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
    static String filePath = "src/main/resources/com/example/game/account/account.txt";
    static FileInputStream fileInput;
    static FileOutputStream fileOutput;
    static FileOutputStream fileWrite;

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

    static {
        try {
            fileInput = new FileInputStream(filePath);
            fileOutput = new FileOutputStream(filePath, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFile() throws IOException {
        Scanner scanner =new Scanner(fileInput);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] parts = s.split("\\.");
            Account account = new Account(parts[0]);
            accounts.add(account);
            account.setScore(Long.parseLong(parts[1]));
        }
        scanner.close();
    }

    public static void writeFile(String text) throws IOException {
        byte[] array = text.getBytes();
        fileOutput.write(array);
    }

    public static void updateFile() throws IOException {
        fileWrite = new FileOutputStream(filePath);
        String text = "";
        byte[] array = text.getBytes();
        fileWrite.write(array);
        fileWrite.close();

        for(Account account : accounts){
            text = account.getUsername() +"."+ account.getScore() +"\n";
            array = text.getBytes();
            fileOutput.write(array);
        }
    }

    public void updateScore(long newScore) throws IOException {
        setScore(newScore);
        updateFile();
    }

    public static Account accountExist(String username) throws IOException {
        readFile();
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
