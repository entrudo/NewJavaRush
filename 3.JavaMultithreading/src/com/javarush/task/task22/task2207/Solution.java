package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder builder = new StringBuilder();

        while (fileReader.ready()) {
            String[] temp = fileReader.readLine().split(" ");
            for (String s : temp) {
                builder.append(s + " ");
            }
        }
        String[] arrayOfWord = builder.toString().split(" ");

        for (int i = 0; i < arrayOfWord.length; i++) {
            String firstWord = arrayOfWord[i];
            for (int j = 0; j < arrayOfWord.length; j++) {
                if (i == j) {
                    break;
                }
                StringBuilder ifWord = new StringBuilder(arrayOfWord[j]);
                String secondWord = arrayOfWord[j];
                if (firstWord.equals(ifWord.toString()) || firstWord.equals(ifWord.reverse().toString())) {
                    Pair pair = new Pair(firstWord, secondWord);
                    if (!(result.contains(pair))) {
                        result.add(pair);
                    }
                }
            }
        }

        for (Pair pair : result) {
            System.out.println(pair.toString());
        }

        reader.close();
        fileReader.close();

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
