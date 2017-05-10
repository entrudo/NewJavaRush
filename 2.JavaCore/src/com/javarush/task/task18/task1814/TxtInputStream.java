package com.javarush.task.task18.task1814;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.List;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String[] list = fileName.split("\\.");
        if (!list[list.length - 1].equals("txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public TxtInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    public TxtInputStream(FileDescriptor fdObj) {
        super(fdObj);
    }

    @Override
    public int read() throws IOException {
        return super.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return super.skip(n);
    }

    @Override
    public int available() throws IOException {
        return super.available();
    }

    @Override
    public FileChannel getChannel() {
        return super.getChannel();
    }

    @Override
    protected void finalize() throws IOException {
        super.finalize();
    }

    @Override
    public synchronized void mark(int readlimit) {
        super.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        super.reset();
    }

    @Override
    public boolean markSupported() {
        return super.markSupported();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    public static void main(String[] args) throws IOException{

        try (TxtInputStream stream = new TxtInputStream
                ("/Users/alex/Documents/Projects/JavaRushTasks/2.JavaCore/src/com/javarush/task" +
                        "/task18/task1814/file.txt")) {
        }catch (UnsupportedFileNameException e) {
            e.printStackTrace();
        }
    }
}

