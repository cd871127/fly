package com.anthony.thread.threadhttp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by CHENDONG239 on 2017-02-09.
 */
public class MultiThreadHttpTest {
    @Test
    public void start() throws Exception {

        MultiThreadHttp mth=new MultiThreadHttp(5,null);
        mth.start();
    }

}