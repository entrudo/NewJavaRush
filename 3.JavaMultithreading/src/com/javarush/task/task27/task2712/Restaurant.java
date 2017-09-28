package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.Locale;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.ENGLISH);
//        ConsoleHelper.writeMessage(Dish.allDishesToString());
//        ConsoleHelper.writeMessage(ConsoleHelper.getAllDishesForOrder().toString());
//        new Tablet(5).createOrder();

        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Amigo");
        cook.addObserver(new Waiter());
        tablet.addObserver(cook);
        tablet.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}
