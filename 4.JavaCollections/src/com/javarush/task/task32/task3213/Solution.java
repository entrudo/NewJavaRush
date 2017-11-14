package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(reader);
        String strFromReader = br.readLine();
//        strFromReader += br.readLine();

        char[] array = strFromReader.toCharArray();

        for (char c : array) {
            int newChar = (int) c + key;
            stringBuilder.append((char) newChar);
        }


        return stringBuilder.toString();
    }

}
