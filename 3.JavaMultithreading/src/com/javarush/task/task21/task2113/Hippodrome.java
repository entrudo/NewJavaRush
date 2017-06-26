package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        int distanceOfWinner = (int) horses.get(0).getDistance();
        Horse winnerHorse = null;

        for (Horse horse: horses) {
            if (distanceOfWinner < (int) horse.getDistance()) {
                distanceOfWinner = (int) horse.getDistance();
            }
        }

        for (Horse horse: horses) {
            if (distanceOfWinner == (int) horse.getDistance()) {
                winnerHorse = horse;
            }
        }
        return winnerHorse;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        List<Horse> list = new ArrayList<>();
        list.add(new Horse("Horse1", 3, 0));
        list.add(new Horse("Horse2", 3, 0));
        list.add(new Horse("Horse3", 3, 0));
        game = new Hippodrome(list);
        try {
            game.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        game.printWinner();
    }
}
