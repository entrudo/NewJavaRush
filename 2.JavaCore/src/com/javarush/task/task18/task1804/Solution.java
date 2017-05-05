package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = reader.readLine();
        FileInputStream fileReader = new FileInputStream(nameOfFile);

        List<Integer> listOfByteInFile = new ArrayList<>();
        HashMap<Integer, Integer> mapOfByteInFile = new HashMap<>();
        int count = 127;

        while (fileReader.available() > 0) {
            int byteOfFile = fileReader.read();
            listOfByteInFile.add(byteOfFile);
        }

        for (int i = 0; i < listOfByteInFile.size(); i++) {
            if (mapOfByteInFile.containsKey(listOfByteInFile.get(i))) {
                for (HashMap.Entry<Integer, Integer> list : mapOfByteInFile.entrySet()){
                    if (list.getKey().equals(listOfByteInFile.get(i))) {
                        mapOfByteInFile.put(listOfByteInFile.get(i), list.getValue() + 1);
                    }
                }

            } else {
                mapOfByteInFile.put(listOfByteInFile.get(i), 1);
            }
        }

        for (HashMap.Entry<Integer, Integer> pair : mapOfByteInFile.entrySet()) {
            if (count >= pair.getValue()) {
                count = pair.getValue();
            }
        }

        for (HashMap.Entry<Integer, Integer> print : mapOfByteInFile.entrySet()) {
            if (count == print.getValue()) {
                System.out.print(print.getKey() + " ");
            }
        }

        reader.close();
        fileReader.close();
    }
}
