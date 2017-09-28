package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.ENGLISH);
        List<Tablet> tabletList = new ArrayList<>();
        OrderManager orderManager = new OrderManager();

        Cook cook = new Cook("Amigo");
        Cook cookVasia = new Cook("Vasia");

        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.addObserver(orderManager);
            tablet.addObserver(orderManager);
            tabletList.add(tablet);
        }

        Waiter waiter = new Waiter();
        StatisticManager.getInstance().register(cookVasia);
        StatisticManager.getInstance().register(cook);
        cook.addObserver(waiter);
        cookVasia.addObserver(waiter);

        Thread randomOrderGeneratorTask = new Thread(new RandomOrderGeneratorTask(tabletList,
                ORDER_CREATING_INTERVAL));
        randomOrderGeneratorTask.start();

        Thread.sleep(1000);
        randomOrderGeneratorTask.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}
