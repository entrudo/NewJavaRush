package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import javax.xml.crypto.dsig.XMLSignatureException;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends FileNotFoundException {
    }

    static class MyException2 extends NullPointerException {
    }

    static class MyException3 extends ArithmeticException {
    }

    static class MyException4 extends XMLSignatureException {
    }
}

