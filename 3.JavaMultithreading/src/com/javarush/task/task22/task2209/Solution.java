package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder builder = new StringBuilder();

        while (fileReader.ready()) {
            String[] temp = fileReader.readLine().split(" ");

            for (String s : temp) {
                builder.append(s + " ");
            }
        }

        String[] wordsArray = builder.toString().split(" ");

        reader.close();
        fileReader.close();
        StringBuilder result = getLine(wordsArray);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null) {return new StringBuilder();}
        if (words.length==0) {return new StringBuilder();}

        //String[] array = i.split(" ");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s: words) {
            arrayList.add(s);
        }
        int neededCounter = arrayList.size();
        StringBuilder resultBuilder = new StringBuilder();
        while (true)
        {
            int wordCounter = 0;
            ArrayList<String> temp = new ArrayList<>(arrayList);
            Collections.shuffle(temp);
            StringBuilder tempBuilder = new StringBuilder();
            tempBuilder.append(arrayList.get(0));
            temp.remove(arrayList.get(0));
            boolean canAdd = true;

            while (canAdd)
            {
                {
                    ArrayList<String> toDelete = new ArrayList<>();
                    for (String s : temp)
                    {
                        StringBuilder word = new StringBuilder(s);
                        // если конец стрингбилдера равен первой букве другого слова
                        if (tempBuilder.substring(tempBuilder.length() - 1).equals(word.reverse().substring(s.length() - 1).toLowerCase()))
                        {
                            tempBuilder.append(" " + s);
                            toDelete.add(s);
                            wordCounter++;
                            continue;
                        }
                        // если начало стрингбилдера равно последней букве другого слова "Киев Вена" - "Нью Йорк"
                        if (tempBuilder.toString().substring(0, 1).toLowerCase().equals(s.substring(s.length() - 1).toLowerCase()))
                        {
                            tempBuilder.reverse().append(" " + word);
                            tempBuilder.reverse();
                            toDelete.add(s);
                            wordCounter++;
                            continue;
                        }
                    }
                    // удаляем уже вставленные слова
                    for (String s : toDelete)
                    {
                        temp.remove(s);
                    }
                    toDelete.clear();
                    // если ни к концу ни к началу нельзя добавить символ - break;
                    for (String s : temp)
                    {
                        StringBuilder word = new StringBuilder(s);
                        if (!tempBuilder.substring(tempBuilder.length() - 1).equals(word.reverse().substring(s.length() - 1).toLowerCase()) &&
                                !tempBuilder.toString().substring(0, 1).toLowerCase().equals(s.substring(s.length() - 1).toLowerCase()))
                        {
                            canAdd = false;
                        }
                    }
                }
                resultBuilder = tempBuilder;
                if (wordCounter==neededCounter-1) {
                    return resultBuilder;
                }
            }
        }
    }

//
//
//
//
//        StringBuilder stringBuilder = new StringBuilder();
//        if (words == null || words.length == 0) return stringBuilder;
//        if (words.length==1 || words[0].equals("")) return stringBuilder.append(words[0]);
//
//        List<String> listOfWords = new ArrayList<>(Arrays.asList(words));
//        List<String> resultList = new ArrayList<>();
//
//        resultList.add(listOfWords.get(0));
//
//        for (int i = 0; i < listOfWords.size(); i++) {
//            String firstW = resultList.get(resultList.size() - 1);
//            String lastCrFirst = firstW.substring(firstW.length() - 1, firstW.length());
//            for (String s : listOfWords) {
//                String firstCrSecond = s.substring(0, 1);
//                if (lastCrFirst.equals(firstCrSecond.toLowerCase())) {
//                    if (!(resultList.contains(s))) {
//                        resultList.add(s);
//                        break;
//                    }
//                }
//            }
//        }
//
//        for (String s : resultList) {
//            stringBuilder.append(s + " ");
//        }
//        stringBuilder.append(resultList);

//        for (int i = 1; i < listOfWords.size(); i++) {
//            String firstW = resultList.get(resultList.size() - 1);
//            String lastCrFirst = firstW.substring(firstW.length() - 1, firstW.length());
//            String secondW = listOfWords.get(i);
//            String firstCrSecond = secondW.substring(0, 1);
//
//            if (lastCrFirst.equalsIgnoreCase(firstCrSecond)) {
//                resultList.add(secondW);
//            }
//        }


//        for (int i = 0; i < words.length; i++) {
//            String firstWord = words[i].substring(words[i].length()-1, words[i].length());
//            for (int j = 0; j < words.length; j++) {
//                if (i == j) {
//                    break;
//                }
//
//                String secondWord = words[j].substring(0, 1);
//                if (firstWord.equalsIgnoreCase(secondWord)) {
//                    System.out.println(words[i] + words[j]);
//                    if (!(stringBuilder.toString().contains(words[i])) && !(stringBuilder
//                            .toString().contains(words[j]))) {
//                        stringBuilder.append(words[i] + " ").append(words[j] + " ");
//                    } else if (!(stringBuilder.toString().contains(words[i]))) {
//                        stringBuilder.append(words[i] + " ");
//                    } else if (!(stringBuilder.toString().contains(words[j]))) {
//                        stringBuilder.append(words[i] + " ");
//                    }
//                }
//            }
//        }
//        return stringBuilder;
//    }
}
