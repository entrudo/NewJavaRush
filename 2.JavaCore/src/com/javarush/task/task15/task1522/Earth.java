package com.javarush.task.task15.task1522;

public class Earth implements Planet {
    private Earth() {
    }

    private static class SingeltonHolder {
        private static final Earth earth = new Earth();
    }

    public static Earth getInstance() {
        return SingeltonHolder.earth;
    }
}
