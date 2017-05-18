package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameOfFileForRead= "";
        String nameOfFileForWrite = "";
        int count = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        nameOfFileForRead = reader.readLine();
        nameOfFileForWrite = reader.readLine();

        FileReader readerForFileRead = new FileReader(nameOfFileForRead);
        FileWriter readerForFileWrite = new FileWriter(nameOfFileForWrite);



        while (readerForFileRead.ready()) {
            count++;
            int data = readerForFileRead.read();
            if (count % 2 == 0) {
                readerForFileWrite.write(data);
            }
        }

        reader.close();
        readerForFileRead.close();
        readerForFileWrite.close();
    }
}
