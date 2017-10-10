package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String temp = null;
        for (int i = 2; i < 37; i++) {
            try {
                BigInteger bgInt = new BigInteger(args[0], i);

                temp = Integer.toString(i);
                break;
            } catch (Exception ignored) {
            }
        }

        if (temp == null) {
            System.out.println("incorrect");
        } else {
            System.out.println(temp);
        }
    }
}