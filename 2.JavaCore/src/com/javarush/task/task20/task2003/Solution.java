package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public Properties property = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        InputStream inputStream = new FileInputStream(reader.readLine());
        load(inputStream);

        reader.close();
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        property.putAll(properties);
        property.store(outputStream, "Write properties");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        property.load(inputStream);

        for (Map.Entry<Object, Object> map : property.entrySet()) {
            properties.put(map.getKey().toString(), map.getValue().toString());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        FileOutputStream outputStream = new FileOutputStream("File1.txt");
        solution.save(outputStream);
        outputStream.close();
    }
}
