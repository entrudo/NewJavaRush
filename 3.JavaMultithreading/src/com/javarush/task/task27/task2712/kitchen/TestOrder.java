package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
        initDishes();
    }

    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<>();
        int count = (int) (Math.random() * Dish.values().length);
        for (int i = 0; i < count; i++) {
            dishes.add(Dish.values()[(int) (Math.random() * Dish.values().length)]);
        }
    }
}
