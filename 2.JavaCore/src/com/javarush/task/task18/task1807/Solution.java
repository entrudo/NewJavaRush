package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        int count = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = fileName = reader.readLine();
        FileInputStream fileReader = new FileInputStream(fileName);

        while (fileReader.available() > 0) {
            int charatter = fileReader.read();

            if (charatter == 44) {
                count++;
            }
        }

        System.out.println(count);

        fileReader.close();
        reader.close();
    }
}
