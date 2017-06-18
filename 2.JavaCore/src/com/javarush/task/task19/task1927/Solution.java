package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String ad = "JavaRush - курсы Java онлайн";

        System.setOut(new PrintStream(outputStream));

        testString.printSomething();

        System.setOut(printStream);

        String[] array = outputStream.toString().split("\n");

        for (int i = 0; i < array.length; i++) {
            if (!(i % 2 == 0)) {
                System.out.println(array[i]);
                System.out.println(ad);
            } else {
                System.out.println(array[i]);
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
