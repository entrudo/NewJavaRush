package com.javarush.task.task19.task1910;

/* 
Пунктуация
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

        builderWrite.append(builder.toString().replaceAll("[\\p{Punct}+|\\s]", ""));

        fileWriter.write(builderWrite.toString());

        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
