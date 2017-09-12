package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> listOfDishes = new ArrayList<>();
        ConsoleHelper.writeMessage("Выберите блюда. Для завершения наберите 'exit'.");
        writeMessage(Dish.allDishesToString());
        while (true) {
            String readString = readString();
            if (readString.equals("exit")) {
                break;
            }

            for (Dish dish : Dish.values()) {
                if (dish.name().equalsIgnoreCase(readString)) {
                    listOfDishes.add(dish);
                } else {
                    writeMessage("Нет такого блюда");
                }
            }
        }

        return listOfDishes;
    }
}
