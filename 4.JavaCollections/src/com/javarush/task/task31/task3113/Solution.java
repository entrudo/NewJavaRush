package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    private static int countOfFiles = 0;
    private static int countOfFolders = 0;
    private static long totalSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Path folder = Paths.get(reader.readLine());

        if (!Files.isDirectory(folder)) {
            System.out.println(folder.toAbsolutePath().toString() + " - не папка");
            return;
        }

        Files.walkFileTree(folder, new FileFind());

        System.out.println("Всего папок - " + (countOfFolders - 1));
        System.out.println("Всего файлов - " + countOfFiles);
        System.out.println("Общий размер - " + totalSize);
    }

    private static class FileFind extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            countOfFiles++;
            totalSize += attrs.size();
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            countOfFolders++;
            return FileVisitResult.CONTINUE;
        }
    }

}
