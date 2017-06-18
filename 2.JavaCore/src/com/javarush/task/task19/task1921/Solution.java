package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
//        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        Calendar calendar = Calendar.getInstance();
        calendar.set(1989, 2, 21);
        System.out.println(calendar.getTime());


//        while (fileReader.ready()) {
//            String[] array = fileReader.readLine().split(" ");
//
//        }

//        fileReader.close();

    }
}
