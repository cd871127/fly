package com.anthony;

import com.anthony.thread.TestRunnable;
import com.anthony.thread.TestThread;
import com.anthony.thread.threadhttp.HttpUtil;

/**
 * Created by CHENDONG239 on 2017-02-03.
 */
public class Main {
    public static void main(String[] args) {
        testRunnable();
    }

    static void testThread()
    {
        Thread t1=new TestThread();
        Thread t2=new TestThread();
        t1.start();
        t2.start();
    }

    static void testRunnable()
    {
        Runnable r1=new TestRunnable();
        Runnable r2=new TestRunnable();
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r1);
        System.out.println(Thread.currentThread().getName());
        t1.start();
        t2.start();
        System.out.println(t1.getState());
    }
}
