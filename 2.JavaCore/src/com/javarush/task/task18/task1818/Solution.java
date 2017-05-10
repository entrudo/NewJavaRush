package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameOfFile1 = "";
        String nameOfFile2 = "";
        String nameOfFile3 = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        nameOfFile1 = reader.readLine();
        nameOfFile2 = reader.readLine();
        nameOfFile3 = reader.readLine();

        FileOutputStream fileWriter = new FileOutputStream(nameOfFile1);
        FileInputStream fileReader2 = new FileInputStream(nameOfFile2);
        FileInputStream fileReader3 = new FileInputStream(nameOfFile3);

        while (fileReader2.available() > 0) {
            fileWriter.write(fileReader2.read());
        }

        while (fileReader3.available() > 0) {
            fileWriter.write(fileReader3.read());
        }

        reader.close();
        fileWriter.close();
        fileReader2.close();
        fileReader3.close();
    }
}
