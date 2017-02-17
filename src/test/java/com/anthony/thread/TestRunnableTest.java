package com.anthony.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CHENDONG239 on 2017-02-17.
 */
public class TestRunnableTest {
    public void run() {
        TestRunnable r = new TestRunnable();
        ArrayList<Thread> tlist = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            Thread t = new Thread(r);
            tlist.add(t);
        }

        for (Thread t : tlist)
            t.start();


        try {
            for (Thread t : tlist)
                t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.printSum();
    }

    @Test
    public void test() {
        ReentrantLock myLock = new ReentrantLock();
        Condition condition=myLock.newCondition();
        ArrayList<Thread> tlist = new ArrayList<>();
        TestRunnable r = new TestRunnable();
        r.setCondition(condition);
        for (int i = 0; i < 100; ++i) {
            Thread t = new Thread(r);
            tlist.add(t);
        }
        int i = 0;
        Scanner in = new Scanner(System.in);
        do {
            i = in.nextInt();
            r.con=i;
            condition.signal();
        } while (i != 0);

    }

}