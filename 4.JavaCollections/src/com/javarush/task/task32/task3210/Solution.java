package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(args[0], "rw");

        accessFile.seek(Long.parseLong(args[1]));

        int lengthText = args[2].getBytes().length;

        byte[] array = new byte[lengthText];
        accessFile.read(array, 0, lengthText);

        accessFile.seek(accessFile.length());

        if (args[2].equals(convertByteToString(array))) {
            accessFile.write(new String("true").getBytes());
        } else {
            accessFile.write(new String("false").getBytes());
        }

        accessFile.close();
    }

    public static String convertByteToString(byte readBytes[]) {
        return new String(readBytes);
    }
}
