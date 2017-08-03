package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод

        for (Thread thread : threads) {
            switch (thread.getState()) {
                case NEW:{
                    thread.start();
                    break;
                }
                case WAITING:{
                    thread.interrupt();
                    break;
                }
                case TIMED_WAITING:{
                    thread.interrupt();
                    break;
                }
                case TERMINATED:{
                    System.out.println(thread.getPriority());
                    break;
                }
                case BLOCKED:{
                    thread.interrupt();
                    break;
                }
                case RUNNABLE:{
                    thread.isInterrupted();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.interrupt();
        processThreads(new Thread(), thread);
    }
}
