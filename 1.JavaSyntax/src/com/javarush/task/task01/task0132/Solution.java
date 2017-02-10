package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int result = 0;

        char[] array = Integer.toString(number).toCharArray();

        for (int i = 0; i < array.length; i++) {
            result += Integer.parseInt(Character.toString(array[i]));
        }

        return result;
    }
}