package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameOfFile1 = "";
        String nameOfFile2 = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        nameOfFile1 = reader.readLine();
        nameOfFile2 = reader.readLine();

        FileInputStream fileReader1 = new FileInputStream(nameOfFile1);
        FileInputStream fileReader2 = new FileInputStream(nameOfFile2);


        byte[] buffer = new byte[fileReader1.available()];
        byte[] buffer2 = new byte[fileReader2.available()];

        while (fileReader1.available() > 0) {
            fileReader1.read(buffer);
        }

        FileOutputStream fileWriter = new FileOutputStream(nameOfFile1);

        while (fileReader2.available() > 0) {
            fileReader2.read(buffer2);
        }

        byte[] bufferForWrite = new byte[buffer.length + buffer2.length];

        System.arraycopy(buffer2, 0, bufferForWrite, 0, buffer2.length);
        System.arraycopy(buffer, 0, bufferForWrite, buffer2.length, buffer.length);

        fileWriter.write(bufferForWrite);

        reader.close();
        fileReader1.close();
        fileReader2.close();
        fileWriter.close();
    }
}
