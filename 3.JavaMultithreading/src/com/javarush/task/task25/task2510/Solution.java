package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        UncaughtExceptionHandler uncaughtExceptionHandler = new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error) {
                    System.out.println("Нельзя дальше работать");
                }
                else if (e instanceof Exception) {
                    System.out.println("Надо обработать");
                }
                else if (e != null) {
                    System.out.println("ХЗ");
                }
            }
        };
        this.setUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    public static void main(String[] args) {
    }
}
