package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        String fileName = "";

        ;

        while (true) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                fileName = reader.readLine();
            }

            try (FileInputStream fileInput = new FileInputStream(fileName)) {
                if (fileInput.available() < 1000) {
                    throw new DownloadException();
                }
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
