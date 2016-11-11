package com.example.myshininglibrary.glin.call;

//import org.loader.glin.Callback;
//import org.loader.glin.Params;
//import org.loader.glin.call.*;
//import org.loader.glin.client.IClient;

import com.example.myshininglibrary.glin.Callback;
import com.example.myshininglibrary.glin.Params;
import com.example.myshininglibrary.glin.call.*;
import com.example.myshininglibrary.glin.client.IClient;

/**
 * Created by qibin on 2016/7/14.
 */

public class DelCall<T> extends Call<T> {

    public DelCall(IClient client, String url, Params params, Object tag) {
        super(client, url, params, tag);
    }

    @Override
    public void enqueue(Callback<T> callback) {
        mClient.delete(mUrl, mHeaders, mTag, callback);
    }
}
