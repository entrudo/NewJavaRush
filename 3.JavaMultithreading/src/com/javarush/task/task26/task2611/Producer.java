package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;
    private int count = 1;

    public Producer(ConcurrentHashMap map) {
        this.map = map;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                map.put(Integer.toString(count), "Some text for " + count);
                count++;
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + "thread was terminated");
            }
        }
    }
}
