package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
//    public static String nameFile = "";
//    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
//            String fileName = "d:\\_JavaRush\\_Test\\task18.task1827.txt ";
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                int maxId = 0;
                List<String> list = new LinkedList<>();
                while ((line = fileReader.readLine()) != null) {
                    list.add(line);

                    if (maxId < Integer.parseInt(line.substring(0, 8).trim())) {
                        maxId = Integer.parseInt(line.substring(0, 8).trim());
                    }
                }
                try (FileOutputStream fos = new FileOutputStream(fileName)) {
                    for (String s : list) {
                        fos.write((String.format("%s%n", s)).getBytes());
                    }

                    fos.write(String.format("%-8s%-30s%-8s%-4s%n", ++maxId, args[1], args[2], args[3]).getBytes());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
