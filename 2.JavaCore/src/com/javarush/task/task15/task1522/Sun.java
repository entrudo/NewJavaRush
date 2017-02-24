package com.javarush.task.task15.task1522;

public class Sun implements Planet {
    private static Sun instance = null;

    private Sun() {
    }

    public static synchronized Sun getInstance() {
        if (instance == null) {
            return instance = new Sun();
        }
        return instance;
    }
}
