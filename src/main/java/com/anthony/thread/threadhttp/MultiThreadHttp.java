package com.anthony.thread.threadhttp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENDONG239 on 2017-02-09.
 */
public class MultiThreadHttp {

    private int threadCount;
    private Map<String,Thread> threadMap=new HashMap<>();
    private ArrayList<String> urlList;

    MultiThreadHttp(int threadCount,ArrayList<String> urlList)
    {
        if(urlList.size()<threadCount)
            this.threadCount=urlList.size();
        else
            this.threadCount=threadCount;
        this.urlList=urlList;

        for(int i=0;i!=this.threadCount;++i)
        {
            Thread thread=new HttpUtil();
            threadMap.put("download#"+String.valueOf(i),thread);
        }
    }

    public void start()
    {
        while(!urlList.isEmpty())
        {
            ;
        }
    }
}
