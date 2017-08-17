package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
//        String nameFile = consoleReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        StringBuilder builder = new StringBuilder();

        while (reader.ready()) {
            builder.append(reader.readLine());
        }

        String line = builder.toString().replaceAll("\n", "");

//        Pattern pattern = Pattern.compile("(<span)|<\\/span>");
//        Matcher matcher = pattern.matcher(line);
//
//        System.out.println(line.indexOf("<span"));
//        System.out.println(line.lastIndexOf("</span>"));
//        System.out.println(line.substring(17, 122));
//
//        while (matcher.find()){
//            System.out.println(matcher.group() + matcher.start() + matcher.end());
//        }
//        System.out.println(args[0]);
//        System.out.println(line);

        while (true) {
            try {
                String result = printTag(line);
            } catch (Exception e) {
                break;
            }
        }

//        consoleReader.close();
        reader.close();

    }

    public static String printTag(String line) throws Exception {
        String result = null;
        if (line.contains("<span")) {
            result = line.substring(line.indexOf("<span"), line.lastIndexOf("</span>") + 7);
            System.out.println(result);
            result = result.substring(1, result.length() - 1);
            printTag(result);
        } else {
            throw new Exception();
        }
        return result;
    }
}
