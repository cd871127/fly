package com.anthony.thread.threadhttp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by CHENDONG239 on 2017-02-09.
 */
public class HttpUtilTest {
    @Test
    public void test()
    {
        HttpUtil u=new HttpUtil();
        u.setUrl("www.baidu.com");
//        u.run();
        u.doGet();
    }

}