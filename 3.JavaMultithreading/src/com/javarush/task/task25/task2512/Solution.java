package com.javarush.task.task25.task2512;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (t != null) {
            t.interrupt();
        }

        Throwable throwable = e.getCause();
        if (throwable != null) {
            uncaughtException(t, throwable);
        }
        System.out.println(e);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
