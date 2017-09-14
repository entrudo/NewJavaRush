package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) throws IOException {
        Cook cook = new Cook("Vasya");
        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        tablet.createOrder();

    }
}
