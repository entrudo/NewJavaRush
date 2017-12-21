package com.javarush.task.task39.task3909;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/*
Одно изменение
*/
public class Solution {
    static LinkedList<Character> firstList;
    static LinkedList<Character> secondList;
    public static void main(String[] args) {

    }

    public static boolean isOneEditAway(String first, String second) {
        firstList = new LinkedList<>();
        secondList = new LinkedList<>();

        //листы нужны  для Collections.frequency

        for (Character character : first.toCharArray()) firstList.add(character);
        for (Character character : second.toCharArray()) secondList.add(character);


        if (first.equals("") && second.equals(""))
            return true;

        if (first.equals(second))
            return true;


        //когда строчки равны по длине

        if (first.length() == second.length()) {
            int count = 0;
            for (int i = 0; i < first.length(); i++)

            {

                if (first.charAt(i) != second.charAt(i)) {
                    count++;
                }

            }

            if (count == 1) return true;
            else return false;

        } else if (first.length() - second.length() == 1)

        {

            ArrayList<Integer> positions = new ArrayList<Integer>();


            for (int i = 0; i < first.length(); i++)

            {

                if (Collections.frequency(firstList, firstList.get(i)) != Collections.frequency(secondList, firstList.get(i)))

                    positions.add(i);

            }

            for (Integer i : positions) {

                Character character = firstList.get(i);

                firstList.remove(firstList.get(i));

                if (Arrays.equals(firstList.toArray(), secondList.toArray())) return true;
                else

                    firstList.add(i, character);

            }

        } else if (second.length() - first.length() == 1) {
            ArrayList<Integer> positions2 = new ArrayList<Integer>();

            for (int i = 0; i < second.length(); i++) {

                if (Collections.frequency(secondList, secondList.get(i)) != Collections.frequency(firstList, secondList.get(i)))
                    positions2.add(i);

            }

            for (Integer i : positions2) {
                Character character = secondList.get(i);
                secondList.remove(secondList.get(i));
                if (Arrays.equals(firstList.toArray(), secondList.toArray())) return true;
                secondList.add(i, character);
            }

        }


        return false;
    }
}
