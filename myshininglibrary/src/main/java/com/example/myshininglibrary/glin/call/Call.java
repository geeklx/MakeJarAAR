package com.example.myshininglibrary.glin.call;


import com.example.myshininglibrary.glin.Callback;
import com.example.myshininglibrary.glin.Params;
import com.example.myshininglibrary.glin.client.IClient;

import java.util.LinkedHashMap;

/**
 * Created by qibin on 2016/7/13.
 */

public abstract class Call<T> {
    protected String mUrl;
    protected Params mParams;
    protected IClient mClient;
    protected Object mTag;
    protected boolean shouldCache;
    protected LinkedHashMap<String, String> mHeaders;

    public Call(IClient client, String url, Params params, Object tag, boolean cache) {
        mClient = client;
        mUrl = url;
        mParams = params;
        mTag = tag;
        shouldCache = cache;
    }

    public Call<T> header(LinkedHashMap<String, String> headers) {
        mHeaders = headers;
        return this;
    }

    public Call<T> shouldCache(boolean cache) {
        shouldCache = cache;
        return this;
    }

    public abstract void enqueue(Callback<T> callback);
}
