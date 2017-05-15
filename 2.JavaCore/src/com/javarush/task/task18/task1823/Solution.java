package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        String fileName;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            if ((fileName = reader.readLine()).equals("exit")) {
                break;
            } else {
                Thread thread = new ReadThread(fileName);
                thread.start();
            }
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName = "";
        List<Character> listOfByteInFile = new ArrayList<>();
        HashMap<Character, Integer> mapOfBytes = new HashMap<Character, Integer>();
        private Integer maxNumber = 0;

        public ReadThread(String fileName) throws IOException {
            //implement constructor body
            this.fileName = fileName;
            this.run();
        }

        @Override
        public void run() {
            super.run();
            try {
                checkFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // implement file reading here - реализуйте чтение из файла тут

        public void checkFile() throws IOException {

            FileInputStream fileReader = new FileInputStream(this.fileName);
            while (fileReader.available() > 0) {
                listOfByteInFile.add((char)fileReader.read());
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

            for (Map.Entry<Character, Integer> map : mapOfBytes.entrySet()) {
                if (map.getValue() > maxNumber) {
                    maxNumber = map.getValue();
                }
            }
            
            for (Map.Entry<Character, Integer> map : mapOfBytes.entrySet()) {
                if (maxNumber == map.getValue()){
                    resultMap.put(this.fileName, (int)map.getKey());
                }
            }
            fileReader.close();
        }
    }
}
