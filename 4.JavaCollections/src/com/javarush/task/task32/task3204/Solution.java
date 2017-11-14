package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;


/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        char[] lowCaseStr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] upperCaseStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] numbers = "0123456789".toCharArray();
        char[] allChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        while (byteArray.size() < 8) {
            if (byteArray.size() < 3) {
                byteArray.write(lowCaseStr[getRandomSymbolFromCharArray(lowCaseStr)]);
                byteArray.write(upperCaseStr[getRandomSymbolFromCharArray(upperCaseStr)]);
                byteArray.write(numbers[getRandomSymbolFromCharArray(numbers)]);
            } else {
                byteArray.write(allChars[getRandomSymbolFromCharArray(allChars)]);
            }
        }

        return byteArray;
    }

    public static int getRandomSymbolFromCharArray(char[] array) {
        return (int) (Math.random() * array.length);
    }
}