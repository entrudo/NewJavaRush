package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String s = "null";
        try {
            s = br.readLine();
        } catch (IOException e) {
            throw e;
        }
        return s;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        writeMessage("Please, enter the dish name (" + Dish.allDishesToString() + ") OR type 'exit' to complete the order");
        while (true) {
            String dish = readString().trim();
            if (dish.equalsIgnoreCase("exit"))
                break;
            try {
                dishes.add(Dish.valueOf(dish));
            } catch (IllegalArgumentException e) {
                writeMessage("Sorry, we don't have that dish");
            }
        }
        return dishes;
    }
}
