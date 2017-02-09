package com.anthony.thread.threadhttp;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by CHENDONG239 on 2017-02-09.
 */
public class HttpUtil extends Thread {
    public void setUrl(String url) {
        if(url.indexOf("http://")==-1&&url.indexOf("https://")==-1)
            url="http://"+url;
        this.url = url;
    }

    private String url;

    @Override
    public void run() {
        String res=doGet();
    }

    public String doGet() {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpEntity entity = null;
        CloseableHttpResponse response = null;
        System.out.println(url);
        HttpGet httpGet = new HttpGet(url);
        String res = null;
        try {
            response = client.execute(httpGet);
            System.out.println(response.getStatusLine().toString());
            Header[] headers = response.getAllHeaders();
            for (Header h : headers)
                System.out.println(h.getName() + ": " + h.getValue());
            entity = response.getEntity();
            res = EntityUtils.toString(entity, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                EntityUtils.consume(entity);
                if (null != response) {
                    response.close();
                }
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

}
