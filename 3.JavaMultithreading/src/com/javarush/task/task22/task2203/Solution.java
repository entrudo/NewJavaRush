package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }
        String[] array = string.split("\t");
        char[] tabArray = string.toCharArray();
        int count = 0;
        for (Character c : tabArray) {
            if (c.equals('\t')) {
                count++;
            }
        }
        if (count < 2) {
            throw new TooShortStringException();
        }
        return array[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
