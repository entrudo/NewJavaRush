package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(args[0], "rw");
        if (accessFile.length() > Long.parseLong(args[1])) {
            accessFile.seek(Long.parseLong(args[1]));
        } else {
            accessFile.seek(accessFile.length());
        }
        accessFile.write(args[2].getBytes());
        accessFile.close();

    }
}
