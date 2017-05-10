package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alphabetArray = alphabet.toCharArray();
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;


        while (fileInputStream.available() > 0) {
            char number = (char)fileInputStream.read();
            for (char c : alphabetArray) {
                if (c == number) {
                    count++;
                }
            }
        }

        System.out.println(count);

        fileInputStream.close();
    }
}
