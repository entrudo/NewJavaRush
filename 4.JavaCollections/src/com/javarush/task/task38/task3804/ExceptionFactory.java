package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum message) {
        if (message != null) {
            String s = message.name().substring(0, 1) + message.name().toLowerCase().substring(1).replace("_", " ");
            if (message instanceof ExceptionApplicationMessage) {
                return new Exception(s);
            } else if (message instanceof ExceptionDBMessage) {
                return new RuntimeException(s);
            } else if (message instanceof ExceptionUserMessage) {
                return new Error(s);
            }
        }
        return new IllegalArgumentException();
    }
}
