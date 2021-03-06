package com.example.myshininglibrary.glin.call;


import com.example.myshininglibrary.glin.Callback;
import com.example.myshininglibrary.glin.Params;
import com.example.myshininglibrary.glin.client.IClient;

/**
 * Created by qibin on 2016/7/14.
 */

public class DelCall<T> extends Call<T> {

    public DelCall(IClient client, String url, Params params, Object tag, boolean cache) {
        super(client, url, params, tag, cache);
    }

    @Override
    public void enqueue(Callback<T> callback) {
        mClient.delete(mUrl, mHeaders, mTag, shouldCache, callback);
    }
}
