package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = null;

        while (true) {
            fileName = reader.readLine();
            try {
                file = new FileInputStream(fileName);
                file.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                reader.close();
                return;
            }
        }
    }
}
