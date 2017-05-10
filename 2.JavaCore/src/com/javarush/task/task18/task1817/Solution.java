package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        double countSpace = 0;
        double countNumber = 0;
        char space = ' ';

        while (fileInputStream.available() > 0) {
            char bukva = (char) fileInputStream.read();

            if (bukva == space) {
                countSpace++;
            }

            countNumber++;
        }

        String formatResult = String.format("%.2f", (countSpace / countNumber) * 100);

        System.out.println(formatResult);

        fileInputStream.close();

    }
}
