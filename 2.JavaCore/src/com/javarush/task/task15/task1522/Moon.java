package com.javarush.task.task15.task1522;

public class Moon implements Planet {
    private static Moon instance = null;

    private Moon() {
    }

    public static synchronized Moon getInstance() {
        if (instance == null) {
            return instance = new Moon();
        }
        return instance;
    }
}
