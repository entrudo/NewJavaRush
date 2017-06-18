package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        testString.printSomething();

        String[] symbols = outputStream.toString().split(" ");

        int firstNumber = Integer.parseInt(symbols[0]);
        int secondNumber = Integer.parseInt(symbols[2]);

        System.setOut(consoleStream);

        if (symbols[1].equals("*")) {
            System.out.println(outputStream.toString().trim() + " " + (firstNumber * secondNumber));
        }

        if (symbols[1].equals("+")) {
            System.out.println(outputStream.toString().trim() + " " + (firstNumber + secondNumber));
        }

        if (symbols[1].equals("-")) {
            System.out.println(outputStream.toString().trim() + " " + (firstNumber - secondNumber));
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

