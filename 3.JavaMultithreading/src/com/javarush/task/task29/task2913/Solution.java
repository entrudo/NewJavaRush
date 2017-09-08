package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder builder = new StringBuilder();
        if (a < b) {
            for (int i = a; i <= b; i++) {
                if (i == a) {
                    builder.append(Integer.toString(i));
                } else {
                    builder.append(" ").append(Integer.toString(i));
                }
                if (i == b) {
                    builder.append("\n");
                }
            }
        } else {
            if (a == b) {
                builder.append(Integer.toString(a)).append("\n");
            } else {
                for (int i = a; i >= b; i--) {
                    if (i == a) {
                        builder.append(Integer.toString(i));
                    } else {
                        builder.append(" ").append(Integer.toString(i));
                    }
                }
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}