package com.javarush.task.task18.task1824;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadThread extends Thread{
    private String nameFile;
    public static boolean EXIT = false;

    public static boolean isExit() {
        return EXIT;
    }

    public ReadThread(String nameFile) {
        this.nameFile = nameFile;
    }

    @Override
    public synchronized void start() {
        super.start();
        readFile(this.nameFile);
    }

    @Override
    public void run() {
        super.run();
    }

    public static void readFile(String nameFile) {
        try (FileInputStream fileReader = new FileInputStream(nameFile)) {
        } catch (FileNotFoundException e) {
            System.out.println(nameFile);
            EXIT = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
