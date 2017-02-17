package com.anthony.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CHENDONG239 on 2017-02-03.
 */
public class TestRunnable implements Runnable {

    int sum = 0;
    private ReentrantLock myLock = new ReentrantLock();
    private Condition condition;
    int con=0;
    @Override
    public void run() {
        testCon();
    }
    public void setCondition(Condition condition)
    {
        this.condition=condition;
    }

        private void testCon()
    {
        while(con<100)
        {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        con=1;
        System.out.println(Thread.currentThread().getName());
    }

    public void printSum() {
        System.out.println(sum);
    }

    private void testSyn() {
        for (int i = 0; i < 100; ++i) {
//            myLock.lock();
//            try {
            synchronized (myLock) {
                sum += 1;
            }
//            }finally {
//                myLock.unlock();
//            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
