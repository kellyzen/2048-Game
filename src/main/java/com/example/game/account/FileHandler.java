package com.example.game.account;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public static void writeFile(String text) throws IOException {
        byte[] array = text.getBytes();
        fileOutput.write(array);
    }

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
