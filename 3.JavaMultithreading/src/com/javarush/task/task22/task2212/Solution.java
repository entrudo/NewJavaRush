package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null){return false;}

        if (telNumber.matches("^\\+\\d{12}")){return true;}

        if (telNumber.matches("^\\+\\d{2}\\(\\d{3}\\)\\d{7}")){
            return true;}

        if (telNumber.matches("^\\+\\d{8}-\\d{2}-\\d{2}")){return true;}

        if (telNumber.matches("^\\d{6}-\\d{4}")){return true;}

        return false;
    }

    public static void main(String[] args) {

    }
}
