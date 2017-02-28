package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        File file;
        StringBuilder content = new StringBuilder();

        @Override
        public void setFileName(String fullFileName) {
            file = new File(fullFileName);
        }

        @Override
        public String getFileContent() {
            return this.content.toString();
        }

//        @Override
//        public void join() throws InterruptedException {
//
//        }

        @Override
        public void start() {
            this.run();
        }

        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String temp;
                while ((temp = reader.readLine()) != null){
                    this.content.append(temp + " ");
                }
            } catch (IOException e){
            }
        }


    }
}
