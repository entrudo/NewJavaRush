package com.javarush.task.task26.task2612;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        //implement logic here, use the lock field
        if (lock.tryLock()) {
            try {
                lock.lock();
                ifLockIsFree();
            }catch (Exception e) {
            } finally {
                lock.unlock();
            }
        } else {
            ifLockIsBusy();
        }

    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}
