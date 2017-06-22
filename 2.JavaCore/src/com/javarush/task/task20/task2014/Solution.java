package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        FileInputStream fileInputStream = new FileInputStream("File.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("File.txt");

        Solution savedObject = new Solution(10);

        Solution loadedObject = new Solution(20);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.close();
        fileOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        loadedObject = (Solution) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();


        boolean result = savedObject.toString().equals(loadedObject.toString());
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
