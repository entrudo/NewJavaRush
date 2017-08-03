package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
        Thread thread;
        public LoggingStateThread(Thread target) {
            thread = target;
            thread.setDaemon(true);
        }

        @Override
        public void run() {
            State state = thread.getState();
            System.out.println(thread.getState());
            while (state != State.TERMINATED) {
                if (state != thread.getState()) {
                    System.out.println(thread.getState());
                    state = thread.getState();
                }
            }
        }
}
