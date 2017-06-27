package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                if (isFirst == false) {
                    builder.append(" and ");
                }
                builder.append(pair.getKey()).append(" = '").append(pair.getValue()).append("'");
                isFirst = false;
            }
        }

//        StringBuilder builder = new StringBuilder();
//        int count = 0;
//
//        for (Map.Entry<String, String> map : params.entrySet()){
//            if (map.getValue() == null || map.getKey() == null) {
//                break;
//            }
//
//            if (count < 1) {
//                builder.append(map.getKey() + " = " + "\'"+map.getValue()+"\'");
//                count++;
//            } else {
//                builder.append(" and " + map.getKey() + " = " + "\'"+map.getValue()+"\'");
//            }
//        }
        return builder.toString();
    }
}
