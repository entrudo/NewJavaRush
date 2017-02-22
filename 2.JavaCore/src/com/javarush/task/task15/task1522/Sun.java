package com.javarush.task.task15.task1522;

public class Sun implements Planet {
    private Sun() {
    }

    private static class SingeltonHolder {
        private static final Sun sun = new Sun();
    }

    public static Sun getInstance() {
        return SingeltonHolder.sun;
    }
}
