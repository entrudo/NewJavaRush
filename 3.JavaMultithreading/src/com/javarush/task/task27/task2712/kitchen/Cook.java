package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

public class Cook extends Observable {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    void startCookingOrder(Order order) {
        int coolingTime = (order).getTotalCookingTime();
        ConsoleHelper.writeMessage("Start cooking - " + order.toString() + ", cooking time " + coolingTime + "min");
        StatisticManager.getInstance().register(new CookedOrderEventDataRow((order).getTablet().toString(),
                this.name, (order).getTotalCookingTime(), (order).getDishes()));
        setChanged();
        notifyObservers(order);
    }

    @Override
    public String toString() {
        return name;
    }
}
