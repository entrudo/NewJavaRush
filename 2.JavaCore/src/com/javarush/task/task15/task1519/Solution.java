package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String temp = reader.readLine();
            if (temp.equals("exit")){
                return;
            }
    
            if (temp.contains(".")) {
                boolean toString = false;
                Double toDuble = 0.0;
                try {
                    toDuble = Double.parseDouble(temp);
                }catch (NumberFormatException e) {
                    toString = true;
                }
                if (toString) {
                    print(temp);
                    continue;
                }
                print(toDuble);
                continue;
            }
            
            try {
                int number = Integer.parseInt(temp);
                if (number <= 0 || number >= 128) {
                    print((Integer) number);
                } else if (number < 128 && number > 0) {
                    print((short) number);
                }
                continue;
            }catch (NumberFormatException e) {
                
            }
            print(temp);
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
