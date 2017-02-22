package com.javarush.task.task15.task1522;

public class Moon implements Planet {
    private Moon() {
    }

    private static class SingeltonHolder {
        private static final Moon moon = new Moon();
    }

    public static Moon getInstance() {
        return SingeltonHolder.moon;
    }
}
