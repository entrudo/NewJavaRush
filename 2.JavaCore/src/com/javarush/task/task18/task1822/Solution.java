package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(nameOfFile));
        List<String> listOfStr = new ArrayList<>();
        String line = "";

        while ((line = fileReader.readLine()) != null) {
            listOfStr.add(line);
        }

        for (String s : listOfStr) {
            String[] masOfProduct = s.split(" ");
            if (args[0].equals(masOfProduct[0])) {
                System.out.println(s);
            }
        }


        reader.close();
        fileReader.close();
    }
}
