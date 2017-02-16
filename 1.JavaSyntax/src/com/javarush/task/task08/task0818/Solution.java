package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ivan", 1000);
        map.put("Ivan1", 100);
        map.put("Ivan2", 1200);
        map.put("Ivan3", 450);
        map.put("Ivan4", 500);
        map.put("Ivan5", 340);
        map.put("Ivan6", 600);
        map.put("Ivan7", 700);
        map.put("Ivan8", 111);
        map.put("Ivan9", 555);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){

            Map.Entry<String, Integer> pair = iterator.next();
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
            if (pair.getValue() < 500){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
    }
}