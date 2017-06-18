package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));


        while (fileReader.ready()) {
            String str = fileReader.readLine();
            String name = str.replaceAll("[\\w]", "").trim();
            String[] array = str.split(" ");
            Date date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( array[array.length-3]+ "." +
                    array[array.length-2] + "." + array[array.length-1]);
            PEOPLE.add(new Person(name, date));
        }

        fileReader.close();

    }
}
