package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class c : classes) {

            if (Modifier.isPrivate(c.getModifiers()))
                if (Modifier.isStatic(c.getModifiers())) {
                    if (List.class.isAssignableFrom(c)) {
                        try {
                            Constructor constructor = c.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            List list = (List) constructor.newInstance();
                            list.get(0);
                        } catch (IndexOutOfBoundsException e) {
                            // вернуть класс
                            return c;
                        } catch (NoSuchMethodException | InvocationTargetException e) {
//                            e.printStackTrace();
                        }
                    }

                }
        }
        return null;
    }
}
