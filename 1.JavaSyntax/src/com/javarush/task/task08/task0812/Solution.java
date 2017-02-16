package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < 10; i++) {
            String temp = reader.readLine();
            list.add(Integer.parseInt(temp));
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == list.get(i + 1)) {
                count++;
            } else if (count > maxCount) {
                maxCount = count + 1;
                count = 0;
            }
        }

        System.out.println(maxCount);
    }
}