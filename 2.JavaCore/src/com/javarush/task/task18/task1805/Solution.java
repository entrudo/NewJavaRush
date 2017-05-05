package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = reader.readLine();
        FileInputStream fileReader = new FileInputStream(nameOfFile);

        TreeSet<Integer> listOfByte = new TreeSet<Integer>();

        while (fileReader.available() > 0) {
            int byteOfFile = fileReader.read();
            listOfByte.add(byteOfFile);
        }

        for (Integer number : listOfByte){
            System.out.print(number + " ");
        }

        reader.close();
        fileReader.close();
    }
}
