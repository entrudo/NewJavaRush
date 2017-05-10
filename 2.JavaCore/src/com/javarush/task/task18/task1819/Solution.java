package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import com.sun.tools.javac.util.ArrayUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameOfFile1 = "";
        String nameOfFile2 = "";

        StringBuilder builder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        nameOfFile1 = reader.readLine();
        nameOfFile2 = reader.readLine();

        FileInputStream fileReader1 = new FileInputStream(nameOfFile1);
        FileInputStream fileReader2 = new FileInputStream(nameOfFile2);
        FileOutputStream fileWriter = new FileOutputStream(nameOfFile1);

        byte[] buffer = new byte[fileReader1.available()];
        byte[] buffer2 = new byte[fileReader2.available()];

        while (fileReader1.available() > 0) {
            builder.append((char)fileReader1.read());
        }

        while (fileReader2.available() > 0) {
            builder.append((char)fileReader2.read());
        }

        byte[] bufferForWrite = new byte[buffer.length + buffer2.length];
        char[] chars = builder.toString().toCharArray();

        for (char c : chars) {
            System.out.println(c);
        }
        for (int i = 0; i < bufferForWrite.length; i++) {
            bufferForWrite[i] = (byte) chars[i];
        }

        fileWriter.write(bufferForWrite);

        reader.close();
        fileReader1.close();
        fileReader2.close();
        fileWriter.close();
    }
}
