package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream(args[0]);
        HashMap<Character, Integer> mapOfBytes = new HashMap<Character, Integer>();
        List<Character> listOfByteInFile = new ArrayList<>();

        while (fileReader.available() > 0) {
            int byteOfFile = fileReader.read();
            listOfByteInFile.add((char)byteOfFile);
        }

        for (int i = 0; i < listOfByteInFile.size(); i++) {
            if (mapOfBytes.containsKey(listOfByteInFile.get(i))) {
                for (HashMap.Entry<Character, Integer> list : mapOfBytes.entrySet()){
                    if (list.getKey().equals(listOfByteInFile.get(i))) {
                        mapOfBytes.put(listOfByteInFile.get(i), list.getValue() + 1);
                    }
                }

            } else {
                mapOfBytes.put(listOfByteInFile.get(i), 1);
            }
        }

        Map<Character, Integer> sortedMapOfBytes = new TreeMap<>(mapOfBytes);

        for (HashMap.Entry<Character, Integer> map : sortedMapOfBytes.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }

        fileReader.close();

    }
}
