package com.anthony.thread;

/**
 * Created by CHENDONG239 on 2017-02-03.
 */
public class TestThread extends Thread {
    int i=0;
    public void run()
    {
        for(;i<=10;++i) {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}
