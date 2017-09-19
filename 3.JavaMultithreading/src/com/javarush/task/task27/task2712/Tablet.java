package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    final int number;
    static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            if (!order.isEmpty()) {
                setChanged();
                notifyObservers(order);
                ConsoleHelper.writeMessage(order.toString());
                AdvertisementManager adManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                adManager.processVideos();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        } finally {
            return order;
        }
    }

    @Override
    public String toString() {
        return String.format("Tablet{number=%d}", number);
    }
}
