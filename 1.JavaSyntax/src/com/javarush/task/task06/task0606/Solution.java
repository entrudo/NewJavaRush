package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        
        char[] array = number.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            int temp = Integer.parseInt(Character.toString(array[i]));
            if (temp % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " +even + " Odd: " + odd);
    }
}
