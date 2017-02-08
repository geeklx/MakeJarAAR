package com.example.myshininglibrary.glin.call;


import com.example.myshininglibrary.glin.Callback;
import com.example.myshininglibrary.glin.Params;
import com.example.myshininglibrary.glin.client.IClient;

/**
 * Created by qibin on 2016/7/13.
 */

public class PostCall<T> extends Call<T> {

    public PostCall(IClient client, String url, Params params, Object tag, boolean cache) {
        super(client, url, params, tag, cache);
    }

    @Override
    public void enqueue(final Callback<T> callback) {
        mClient.post(mUrl, mHeaders, mParams, mTag, shouldCache, callback);
    }
}
