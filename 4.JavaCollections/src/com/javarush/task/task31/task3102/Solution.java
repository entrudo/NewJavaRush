package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        Stack<File> array = new Stack<>();

        array.push(new File(root));

        while (!array.isEmpty()) {
            File currentFile = array.pop();

            if (currentFile.isDirectory()) {
                for (File file : currentFile.listFiles()) {
                    array.push(file);
                }
            }

            if (currentFile.isFile()) {
                result.add(currentFile.getAbsolutePath());
            }
        }

        return result;

    }

    public static void main(String[] args) throws IOException {
        for (String s : getFileTree
                ("/Users/alex/Documents/Projects/JavaRushTasks/4.JavaCollections/src/com" +
                        "/javarush/task/task31/task3102")) {
            System.out.println(s);
        }
    }
}
