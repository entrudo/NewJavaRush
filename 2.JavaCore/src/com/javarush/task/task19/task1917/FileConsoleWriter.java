package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/


import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter {
    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
    }

    public static void main(String[] args) {

    }

    @Override
    public void write(int c) throws IOException {
        super.write(c);
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        super.write(cbuf);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str) throws IOException {
        super.write(str);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        super.write(str, off, len);
    }
}
