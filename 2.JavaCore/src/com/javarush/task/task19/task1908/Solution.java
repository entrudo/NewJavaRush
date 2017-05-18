package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        StringBuilder builder = new StringBuilder();
        StringBuilder builderWrite = new StringBuilder();


        while (fileReader.ready()) {
            builder.append(fileReader.readLine());
        }

        String[] arraysOfWord = builder.toString().split(" ");

        for (String s : arraysOfWord) {
            int number = 0;
            try {
                number = Integer.parseInt(s);
            } catch (Exception e) {
                continue;
            }
            builderWrite.append(number + " ");
        }

        fileWriter.write(builderWrite.toString());

        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
