package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }


//    5. Реализация метода run для Consumer:
//            5.1. Усыпи трэд на 0.45 секунды.
//5.2. В бесконечном цикле забери элемент из очереди методом take и выведи в консоль «Processing item.toString()».

    @Override
    public void run() {

        try {
            if (!Thread.currentThread().isInterrupted()) {
                Thread.currentThread().sleep(450);
                while (true) {
                    ShareItem shareItem = queue.take();
                    System.out.format("Processing %s%n", shareItem.toString());
                }
            }
        } catch (InterruptedException ignored) {
        }
    }
}
