package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset win = Charset.forName("Windows-1251");
        Charset UTF = Charset.forName("UTF-8");

        InputStream inputStream = new FileInputStream(args[0]);
        byte[] buffer = new byte[inputStream.available()];

        inputStream.read(buffer);
        String stringToWrite = new String(buffer, UTF);
        buffer = stringToWrite.getBytes(win);
        OutputStream outputStream = new FileOutputStream(args[1]);
        outputStream.write(buffer);
        inputStream.close();
        outputStream.close();





//        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
//        StringBuilder builder = new StringBuilder();
//
//        while (fileReader.ready()) {
//            builder.append(fileReader.readLine());
//        }
//
//        String stringToWrite = new String(builder.toString().getBytes(), win);
//
//        OutputStream outputStream = new FileOutputStream(args[1]);
//        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
//        outputStream.write();
    }
}
