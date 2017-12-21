package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object character = new Character('s');
        System.out.println((byte) character);
    }

    public void methodThrowsNullPointerException() {

        String str = null;
        str.length();

    }


    public static void main(String[] args) {

    }
}
