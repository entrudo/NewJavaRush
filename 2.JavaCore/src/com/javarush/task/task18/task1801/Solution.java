package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = reader.readLine();
        FileInputStream fileReader = new FileInputStream(nameOfFile);
        int byteInFile = 0;

        while (fileReader.available() > 0) {
            int byteOfFile = fileReader.read();
            if (byteOfFile > byteInFile) {
                byteInFile = byteOfFile;
            }
        }
        System.out.println(byteInFile);
        reader.close();
        fileReader.close();
    }
}
