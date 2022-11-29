package com.example.game.account;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * FileHandler class.
 * Read/write/update file (account.txt).
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class FileHandler {
    static FileInputStream fileInput;
    static FileOutputStream fileOutput;
    static FileOutputStream fileWrite;
    static String filePath = "src/main/resources/com/example/game/account/account.txt";

    static {
        try {
            fileInput = new FileInputStream(filePath);
            fileOutput = new FileOutputStream(filePath, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * Read from file (account.txt) line by line.
     * Create account class for each player.
     * Set the player's username and high score.
     *
     * @param accounts arraylist from Account class
     */
    public static void readFile(ArrayList<Account> accounts) throws IOException {
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

    /**
     *
     * Write the file (account.txt) on new line.
     * Append new player's username and high score in file.
     *
     * @param text text to be added in file
     */
    public static void writeFile(String text) throws IOException {
        byte[] array = text.getBytes();
        fileOutput.write(array);
    }

    /**
     *
     * Update player's new high score into the file (account.txt).
     *
     * @param accounts arraylist from Account class
     */
    public static void updateFile(ArrayList<Account> accounts) throws IOException {
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
}
