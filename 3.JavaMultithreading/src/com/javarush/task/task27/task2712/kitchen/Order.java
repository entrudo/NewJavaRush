package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    protected List<Dish> dishes;
    private final Tablet tablet;

    public List<Dish> getDishes() {
        return dishes;
    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        try {
            dishes = ConsoleHelper.getAllDishesForOrder();
//            ConsoleHelper.writeMessage(toString());
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) return "";
        return "Your order: " + dishes + " of " + tablet.toString();
    }

    public int getTotalCookingTime() {
        int cookingTime = 0;
        for (Dish dish : dishes) {
            cookingTime += dish.getDuration();
        }
        return cookingTime;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
