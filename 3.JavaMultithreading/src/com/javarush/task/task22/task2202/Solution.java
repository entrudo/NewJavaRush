package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }
        int count = 0;
        int lastSymbol = string.length();
        char[] array = string.toCharArray();

        for (Character c : array) {
            if (c.equals(' ')){
                count++;
            }
        }

        if (!(Character.isLetter(array[string.length()-1]))) {
            lastSymbol = string.length() - 1;
        }

        if (count < 4) {
            throw new TooShortStringException();
        }

        return string.substring(string.indexOf(" ") + 1, lastSymbol);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
