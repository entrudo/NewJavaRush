package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static List<File> nameOfFiles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File resultFile = new File(args[1]);
        File allFilesContent = new File(resultFile.getParent() + "/allFilesContent.txt");

//        if (FileUtils.isExist(resultFile)) {
//            FileUtils.renameFile(resultFile, allFilesContent);
//        }
        FileUtils.renameFile(resultFile, allFilesContent);

        try (FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)) {

            stepFolder(args[0]);

            nameOfFiles.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

            for (File s : nameOfFiles) {
                FileInputStream fileInputStream = new FileInputStream(s);
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read());
                }
                fileOutputStream.write(System.lineSeparator().getBytes());
//            fileOutputStream.flush();
                fileInputStream.close();
            }
            fileOutputStream.close();
        }


    }

    public static void stepFolder(String path) {
        File folder = new File(path);
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                if (file.length() <= 50) {
                    nameOfFiles.add(file);
                } else {
                    FileUtils.deleteFile(file);
                }
            } else {
                stepFolder(file.getPath());
                continue;
            }
        }
    }
}
