package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    protected Lock lock = new ReentrantLock();

    public void someMethod() {
        //implement logic here, use the lock field
    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}
