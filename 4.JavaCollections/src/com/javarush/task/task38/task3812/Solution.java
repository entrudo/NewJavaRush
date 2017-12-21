package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            Annotation[] s = c.getAnnotations();
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals(PrepareMyTest.class)) continue;
                Class<?> type = s[i].annotationType();
                Method m = null;
                try {
                    m = type.getMethod("fullyQualifiedNames");
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                String[] rp = null;
                try {
                    rp = (String[]) m.invoke(s[i]);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < rp.length; j++) {
                    System.out.println(rp[j]);
                }
            }
            return true;
        } else
            return false;
    }

    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            Annotation[] s = c.getAnnotations();
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals(PrepareMyTest.class)) continue;
                Class<?> type = s[i].annotationType();
                Method m = null;
                try {
                    m = type.getMethod("value");
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                Class<?>[] rp = null;
                try {
                    rp = (Class<?>[]) m.invoke(s[i]);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < rp.length; j++) {
                    System.out.println(rp[j].getSimpleName());
                }
            }
            return true;
        } else
            return false;
    }
}
