package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        List<String> listOfWord = new ArrayList<>();

        while (fileReader.ready()){
            String[] array = fileReader.readLine().split(" ");

            for (String str : array) {
                if (str.length() > 6) {
                    listOfWord.add(str);
                }
            }
        }

        for (int i = 0; i < listOfWord.size(); i++) {
            if (!(i == 0)) {
                fileWriter.write("," + listOfWord.get(i));
            } else {
                fileWriter.write(listOfWord.get(i));
            }
        }

        fileReader.close();
        fileWriter.close();

    }
}
