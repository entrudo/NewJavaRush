package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String temp = "";
        int cisl = 0;
        int znam = 0;

        while (true) {
            temp = reader.readLine();
            if (temp.equals("-1")) {
                znam = list.size();

                for (Integer number : list){
                    cisl += number;
                }
                System.out.println((double) cisl/znam);
                return;
            } else {
                list.add(Integer.parseInt(temp));
            }
        }
    }
}

