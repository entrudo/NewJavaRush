package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

        String[] array = getTokens("level22.lesson13.task01", ".");
        for (String s : array) {
            System.out.println(s);
        }

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] array = new String[stringTokenizer.countTokens()];

        for (int i = 0; stringTokenizer.hasMoreTokens(); i++) {
            array[i] = stringTokenizer.nextToken();
        }

        return array;
    }
}
