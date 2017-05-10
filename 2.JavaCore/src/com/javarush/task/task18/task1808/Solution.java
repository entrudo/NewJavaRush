package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(s1);
        FileOutputStream outputStream1 = new FileOutputStream(s2);
        FileOutputStream outputStream2 = new FileOutputStream(s3);

        ArrayList<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0){
            int count = inputStream.read();
            list.add(count);
        }

        if(list.size()%2 == 0){
            for (int i = 0; i < list.size()/2; i++){
                outputStream1.write(list.get(i));
            }

            for (int i = list.size()/2; i < list.size(); i++){
                outputStream2.write(list.get(i));
            }
        }

        else{
            for (int i = 0; i <= (list.size()-1)/2; i++){
                outputStream1.write(list.get(i));
            }

            for (int i = (list.size()-1)/2 + 1; i < list.size(); i++){
                outputStream2.write(list.get(i));
            }
        }

        reader.close();
        inputStream.close();
        outputStream1.close();
        outputStream2.close();


//        String fileName1 = "";
//        String fileName2 = "";
//        String fileName3 = "";
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        fileName1 = reader.readLine();
//        fileName2 = reader.readLine();
//        fileName3 = reader.readLine();
//
//        FileInputStream fileReader = new FileInputStream(fileName1);
//        FileOutputStream fileWriter2 = new FileOutputStream(fileName2);
//        FileOutputStream fileWriter3 = new FileOutputStream(fileName3);
//
//        byte[] buff = new byte[fileReader.available()];
//        while (fileReader.available() > 0) {
//            int count = fileReader.read(buff);
//
//            if (count % 2 == 0) {
//                fileWriter2.write(buff, 0, (count/2) +1);
//                fileWriter3.write(buff, count/2, count/2);
//            }
//
//            if (count % 2 != 0 ){
//                fileWriter2.write(buff, 0, (count/2) + 1);
//                fileWriter3.write(buff, (count/2) +1, count-((count/2)+1));
//            }
//        }
//
//        reader.close();
//        fileReader.close();
//        fileWriter2.close();
//        fileWriter3.close();
    }
}
