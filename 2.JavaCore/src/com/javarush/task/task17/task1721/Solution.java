package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        File firstFile = null;
        File secondFile = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFile = new File(reader.readLine());
            secondFile = new File(reader.readLine());
        } catch (IOException e){
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(firstFile.getAbsolutePath()))) {
            String temp = "";
            while ((temp = reader.readLine()) !=null) {
                allLines.add(temp);
            }
        } catch (IOException e) {
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(secondFile.getAbsolutePath()))) {
            String temp = "";
            while ((temp = reader.readLine()) !=null) {
                forRemoveLines.add(temp);
            }
        } catch (IOException e) {
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
        }
    }

    public void joinData () throws CorruptedDataException {
        if (!allLines.containsAll(forRemoveLines)){
            allLines.clear();
            throw new CorruptedDataException();
        } else {
            for (int i = 0; i < allLines.size(); i++) {
                if (forRemoveLines.contains(allLines.get(i))) {
                    allLines.remove(i);
                }
            }
        }
    }
}
