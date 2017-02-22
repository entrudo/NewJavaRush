package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String enterURL = reader.readLine();
        reader.close();

        List<String> list = new ArrayList<>();

        String url2 = enterURL.substring(enterURL.indexOf("?") + 1, enterURL.length());
        String[] allParams = url2.split("\\&");

        for (String str : allParams) {
            String [] localParam = str.split("\\=");

            for (int i = 0; i < localParam.length; i++) {
                if (i % 2 == 0) {
                    if (localParam[i].toLowerCase().equals("obj")) {
                        list.add(localParam[i+1]);
                    }
                    System.out.print(localParam[i] + " ");
                }
            }
        }

        System.out.println();
        for (String str : list) {
            try {
                double number = Double.parseDouble(str);
                alert(number);
            } catch (Exception e) {
                alert(str);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
