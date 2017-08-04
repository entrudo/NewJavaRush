package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        Solution solution = new Solution();

        String[] array = args;

        switch (args[0]) {
            case "-c": {
                solution.create(array);
                break;
            }
            case "-u": {
                solution.update(array);
                break;
            }

            case "-d": {
                solution.delete(args[1]);
                break;
            }

            case "-i": {
                solution.info(args[1]);
                break;
            }
        }
    }

    public void create(String[] arrayOfData) {
        if (arrayOfData[2].equals("м")) {
            allPeople.add(Person.createMale(arrayOfData[1], convertDate(arrayOfData[3])));
        } else {
            allPeople.add(Person.createFemale(arrayOfData[1], convertDate(arrayOfData[3])));
        }
        System.out.println(allPeople.size() - 1);
    }

    public void update(String[] arrayOfData) {
        Person person = allPeople.get(Integer.parseInt(arrayOfData[1]));
        person.setName(arrayOfData[2]);
        if (arrayOfData[3].equals("м")) {
            person.setSex(Sex.MALE);
        } else {
            person.setSex(Sex.FEMALE);
        }
        person.setBirthDay(convertDate(arrayOfData[4]));
    }

    public void delete(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
    }

    public void info(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(person.getName() + " ");

        if (person.getSex() == Sex.MALE) {
            stringBuilder.append("м ");
        } else {
            stringBuilder.append("ж ");
        }

        stringBuilder.append(dateForPrint(person.getBirthDay()));

        System.out.println(stringBuilder.toString());

    }

    public Date convertDate(String date) {
        Date dateOfBirthDay = null;

        try {
            dateOfBirthDay = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateOfBirthDay;
    }

    public String dateForPrint(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        return formatter.format(date);
    }
}
