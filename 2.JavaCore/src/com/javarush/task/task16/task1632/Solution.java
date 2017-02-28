package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }


    public static void main(String[] args) {

        for (Thread thread : threads) {
            thread.start();
        }

    }

    public static class ThreadOne extends Thread {
        public void run(){
            while (true) {

            }
        }
    }

    public static class ThreadTwo extends Thread {
        public void run(){
            try {
                if (this.isInterrupted()) {
                    throw new InterruptedException();
                }
            }catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }

    }

    public static class ThreadThree extends Thread {
        public void run(){
            while (true) {
                try {
                    System.out.println("Ура");
                    sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class ThreadFour extends Thread implements Message {
        boolean exit = false;

        public void run(){
            while (!exit) {
            }
        }

        @Override
        public void showWarning() {
            exit = true;
        }
    }

    public static class ThreadFive extends Thread {
        int result;
        public void run(){
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
                String temp;
                while (true) {
                    temp = reader.readLine();
                    if (temp.equals("N")) {
                        System.out.println(result);
                        return;
                    }
                    result += Integer.parseInt(temp);
                }
            } catch (IOException e) {

            }
        }
    }
}