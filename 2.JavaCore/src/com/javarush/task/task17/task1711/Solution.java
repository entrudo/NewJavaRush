package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        Solution solution = new Solution();

        List<String> array = new ArrayList<>();
        for (String str : args) {
            array.add(str);
        }

        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    List<String> listOfCreate = array;
                    listOfCreate.remove(0);
                    int count = 0;
                    String[] dateAboutUser = new String[3];
                    for (String str : listOfCreate) {
                        dateAboutUser[count] = str;
                        if (count == 2) {
                            solution.create(dateAboutUser);
                            count = -1;
                        }
                        count++;
                    }
                }
                break;
            }
            case "-u": {
                synchronized (allPeople) {
                    List<String> listOfUpdate = array;
                    listOfUpdate.remove(0);
                    int count = 0;
                    String[] dateAboutUser = new String[4];
                    for (String str : listOfUpdate) {
                        dateAboutUser[count] = str;
                        if (count == 3) {
                            solution.update(dateAboutUser);
                            count = -1;
                        }
                        count++;
                    }
                }
                break;
            }

            case "-d": {
                synchronized (allPeople) {
                    List<String> listDeleteId = array;
                    listDeleteId.remove(0);
                    solution.delete(listDeleteId);
                }
                break;
            }

            case "-i": {
                synchronized (allPeople) {
                    List<String> listInfoId = array;
                    listInfoId.remove(0);
                    solution.info(listInfoId);
                }
                break;
            }
        }
    }

    private void info(List<String> arg) {
        for (String id : arg) {
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
    }

    private void delete(List<String> arg) {
        for (String id : arg) {
            Person person = allPeople.get(Integer.parseInt(id));
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
        }
    }

    private void update(String[] arrayOfData) {
        Person person = allPeople.get(Integer.parseInt(arrayOfData[0]));
        person.setName(arrayOfData[1]);
        if (arrayOfData[2].equals("м")) {
            person.setSex(Sex.MALE);
        } else {
            person.setSex(Sex.FEMALE);
        }
        person.setBirthDay(convertDate(arrayOfData[3]));
    }

    private void create(String[] arrayOfData) {
        if (arrayOfData[1].equals("м")) {
            allPeople.add(Person.createMale(arrayOfData[0], convertDate(arrayOfData[2])));
        } else {
            allPeople.add(Person.createFemale(arrayOfData[0], convertDate(arrayOfData[2])));
        }
        System.out.println(allPeople.size() - 1);

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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return formatter.format(date);
    }
}
