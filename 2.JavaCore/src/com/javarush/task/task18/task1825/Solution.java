package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameFile = "";
        String nameFileForWrite = "";
        List<String> listOfFiles = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            nameFile = reader.readLine();
            if (!nameFile.equals("end")) {
                listOfFiles.add(nameFile);
            } else {
                break;
            }
        }

        Collections.sort(listOfFiles);

        for (String name : listOfFiles) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(name))){
                builder.append(fileReader.readLine());
            }
        }

        String[] partsOfFile = listOfFiles.get(0).split("\\.");

        nameFileForWrite = partsOfFile[0] + "." + partsOfFile[1];

        FileOutputStream fileWriter = new FileOutputStream(nameFileForWrite);
        fileWriter.write(builder.toString().getBytes());

        fileWriter.close();
        reader.close();
    }
}
