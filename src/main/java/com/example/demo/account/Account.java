package com.example.demo.account;

import com.example.demo.components.dialogComponent.WarningDialog;

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

public class Account implements Comparable<Account> {
    private long score = 0;
    private String username;
    static String filePath = "src/main/resources/com/example/demo/account/account.txt";
    static FileInputStream fileInput;
    static FileOutputStream fileOutput;
    static FileOutputStream fileWrite;

    private static ArrayList<Account> accounts = new ArrayList<>();

    public Account(String username) throws FileNotFoundException {
        this.username =username;
    }

    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
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

    public static boolean usernameIsValid(String username) {
        // return true if the length of username is > 2 or <=15
        if (username.length()<15 && username.length()>2){
            for (int i = 0; i < username.length(); i++) {
                // return false if the character is a white space
                if (Character.isWhitespace(username.charAt(i))) {
                    WarningDialog warningDialog = new WarningDialog();
                    warningDialog.createDialog("Warning Dialog", "Invalid username", "Username should not contain space(s)");
                    return false;
                }
                // return false if the character is neither a letter nor a digit
                if (!Character.isLetterOrDigit(username.charAt(i))) {
                    WarningDialog warningDialog = new WarningDialog();
                    warningDialog.createDialog("Warning Dialog", "Invalid username", "Username must contain letters or digits only");
                    return false;
                }
            }
            return true;
        }
        // return false if the length of username is <= 2 or >15
        else {
            WarningDialog warningDialog = new WarningDialog();
            warningDialog.createDialog("Warning Dialog", "Invalid username", "Username must be more than 2 and less than 15 characters");
            return false;
        }
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
        /*for(Account accounte : accounts){
            System.out.println(accounte.getUsername() +"."+accounte.getScore());
        }*/
        return account;
    }

}
