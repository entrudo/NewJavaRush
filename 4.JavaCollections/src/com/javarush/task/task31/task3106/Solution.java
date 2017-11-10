package com.javarush.task.task31.task3106;

import java.util.Arrays;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        String resultFile = args[0];

        String[] array = new String[args.length - 1];
        for (int i = 1; i <= args.length; i++) {
            array[i - 1] = args[i];
        }

        Arrays.sort(array);



    }
}
