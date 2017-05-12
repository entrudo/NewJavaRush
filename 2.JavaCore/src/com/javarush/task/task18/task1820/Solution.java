package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = "";
        String fileName2 = "";
        StringBuilder strBuild = new StringBuilder();
        StringBuilder strBuild2 = new StringBuilder();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();

        FileInputStream fileReader = new FileInputStream(fileName1);
        FileOutputStream fileWriter = new FileOutputStream(fileName2);

        byte[] buffer = new byte[fileReader.available()];
        while (fileReader.available() > 0) {
            fileReader.read(buffer);
        }

        for (byte b : buffer) {
            strBuild.append((char) b);
        }

        String[] list = strBuild.toString().split(" ");

        for (int i = 0; i < list.length; i++) {
            int number = (int)Math.round(Double.parseDouble(list[i]));
            list[i] = Integer.toString(number);
        }

        for (String s : list) {
            strBuild2.append(s + " ");
        }

        fileWriter.write(strBuild2.toString().getBytes());


        reader.close();
        fileReader.close();
        fileWriter.close();

    }
}
