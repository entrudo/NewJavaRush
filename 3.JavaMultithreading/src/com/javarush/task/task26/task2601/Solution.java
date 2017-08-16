package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Integer[] sortArray = array;
        Arrays.sort(sortArray);
        int median;
        if (sortArray.length % 2 == 0)
            median = (sortArray[sortArray.length/2] + sortArray[sortArray.length/2 - 1])/2;
        else
            median = sortArray[sortArray.length/2];

        Comparator<Integer> comparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                int result =(int) ((Math.abs(o1- median)) - (Math.abs(o2 - median)));
                return result == 0 ? o1-o2 : result;
            }
        };
        Arrays.sort(array,comparator);
        return array;
    }
}
