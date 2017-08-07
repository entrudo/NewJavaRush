package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //    public static String nameFile = "";
//    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        if (args[0].equals("-d")) {

            String line;
            List<String> list = new LinkedList<>();
            while ((line = fileReader.readLine()) != null) {
                list.add(line);
            }

            int index = 0;

            for (int i = 0; i < list.size(); i++) {
                String[] array = list.get(i).split(" ");
                if (args[1].equals(array[0].trim())) {
                    index = i;
                }
            }

            list.remove(index);

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                for (String s : list) {
                    fos.write((String.format("%s%n", s)).getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (args[0].equals("-u")) {
            String line;
            int maxId = 0;
            List<String> list = new LinkedList<>();
            while ((line = fileReader.readLine()) != null) {
                list.add(line);
            }

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                for (int i = 0; i < list.size(); i++) {
                    String[] array = list.get(i).split(" ");
                    if (args[1].equals(array[0].trim())) {
                        fos.write(String.format("%-8s%-30s%-8s%-4s%n", array[0], args[2], args[3],
                                args[4]).getBytes());
                    } else {
                        fos.write((String.format("%s%n", list.get(i))).getBytes());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileReader.close();
        reader.close();
    }


//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        nameFile = reader.readLine();
//
//        if (args.length < 4) {
//            return;
//        }
//
//        BufferedReader fileReader = new BufferedReader(new FileReader(nameFile));
//
//        String productName = args[1];
//        float price = Float.parseFloat(args[args.length - 2]);
//        int quality = Integer.parseInt(args[args.length - 1]);
//        int id = 0;
//
//        while (fileReader.ready()) {
//            String line = fileReader.readLine();
//            list.add(line);
//            if (id < Integer.parseInt(line.substring(0, 8).trim())) {
//                id = Integer.parseInt(line.substring(0, 8).trim());
//            }
//
//        }
//
//        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
//                (nameFile)));
//
//        for (String s : list) {
//            buf.write(String.format("%s%n", s));
//        }
//        buf.write(String.format(Locale.ROOT,"%-8d%-30s%-8.2f%-4d%n", ++id, productName,
//                price, quality));
//
//        buf.close();
//        fileReader.close();
//        reader.close();
//
//    }
}
