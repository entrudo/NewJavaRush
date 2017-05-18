package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner = null;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader("File.txt"));
            String[] personLine = reader.readLine().split(" ");

            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(personLine[5]), Integer.parseInt(personLine[4]),
                    Integer.parseInt(personLine[3]));


            Person person = new Person(personLine[1], personLine[2], personLine[0], calendar.getTime());
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
