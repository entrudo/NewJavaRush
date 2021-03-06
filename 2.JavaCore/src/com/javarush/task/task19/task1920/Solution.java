package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> colloborators = new TreeMap<>();
        SortedSet<Double> treeSet = new TreeSet<>();
        List<String> nameOfReach = new ArrayList<>();

        while (fileReader.ready()) {
            String[] arrayOfLine = fileReader.readLine().split(" ");
            if (colloborators.containsKey(arrayOfLine[0])) {
                for (Map.Entry<String, Double> map : colloborators.entrySet()) {
                    if (map.getKey().equals(arrayOfLine[0])) {
                        double salary = map.getValue() + Double.parseDouble(arrayOfLine[1]);
                        colloborators.put(arrayOfLine[0], salary);
                    }
                }
            } else {
                colloborators.put(arrayOfLine[0], Double.parseDouble(arrayOfLine[1]));
            }
        }

        for (Map.Entry<String, Double> map : colloborators.entrySet()) {
            treeSet.add(map.getValue());
        }

        for (Map.Entry<String, Double> map : colloborators.entrySet()) {
            if (Objects.equals(treeSet.last(), map.getValue())) {
                nameOfReach.add(map.getKey());
            }
        }

        for (String name : nameOfReach) {
            System.out.println(name);
        }

        fileReader.close();
    }
}
