package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    static AtomicInteger integer = new AtomicInteger(1);

    public MyThread() {
        setMyThreadPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setMyThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setMyThreadPriority();
    }

    public MyThread(String name) {
        super(name);
        setMyThreadPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setMyThreadPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setMyThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setMyThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setMyThreadPriority();
    }

    private void setMyThreadPriority() {
        setPriority(integer.get());
        if (integer.get() == 10) integer.set(0);
        integer.incrementAndGet();
    }
}
