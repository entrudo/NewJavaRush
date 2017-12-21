package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileInputStream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        FileInputStream fileInputStream = new FileInputStream("sdsd");
        while (fileInputStream.available() > 0) {
            fileInputStream.read(new byte[1024]);
        }
    }

    public static void main(String[] args) {

    }
}
