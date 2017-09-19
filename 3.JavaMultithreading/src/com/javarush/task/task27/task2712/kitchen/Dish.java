package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    Dish(int duration) {
        this.duration = duration;
    }

    private int duration;

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuffer sb = new StringBuffer();
        for (Dish dish : Dish.values()) {
            sb.append(dish).append(", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(", "));
        return sb.toString().trim();
    }
}
