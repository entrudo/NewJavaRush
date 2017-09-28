package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private int interval;
    private List<Tablet> numberOfTablet;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.interval = interval;
        this.numberOfTablet = tablets;
    }

    @Override
    public void run() {
        if (numberOfTablet.isEmpty()) {
            return;
        }
        while (!Thread.currentThread().isInterrupted()) {
            Tablet tablet = numberOfTablet.get((int) (Math.random() * numberOfTablet.size()));
            tablet.createTestOrder();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
            }
        }
    }
}
