package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] array = new int[15];
        int evenPeople = 0;
        int oddPeople = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < array.length; i++) {
            int temp = Integer.parseInt(reader.readLine());
            array[i] = temp;
        }
        
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                evenPeople += array[i];
            } else if (i%2 == 0) {
                evenPeople += array[i];
            } else {
                oddPeople += array[i];
            }
        }
        if (evenPeople > oddPeople) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else if (evenPeople < oddPeople){
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
