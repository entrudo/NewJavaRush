package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName1 = "";
        String fileName2 = "";
        StringBuilder context = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        fileName1 = reader.readLine();
        fileName2 = reader.readLine();

        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        byte[] buffer = new byte[file1.available()];
        while (file1.available() > 0) {
            file1.read(buffer);
        }


        for (byte b : buffer){
            context.append((char) b);
        }

        context.reverse();
        char[] buffChar = context.toString().toCharArray();

        for (char c : buffChar){
            fileOutputStream.write((byte) c);
        }

        reader.close();
        file1.close();
        fileOutputStream.close();
    }
}
