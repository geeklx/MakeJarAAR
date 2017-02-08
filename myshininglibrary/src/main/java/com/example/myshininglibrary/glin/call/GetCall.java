package com.example.myshininglibrary.glin.call;


import com.example.myshininglibrary.glin.Callback;
import com.example.myshininglibrary.glin.Params;
import com.example.myshininglibrary.glin.client.IClient;

/**
 * Created by qibin on 2016/7/13.
 */

public class GetCall<T> extends Call<T> {

    public GetCall(IClient client, String url, Params params, Object tag, boolean cache) {
        super(client, url, params, tag, cache);
    }

    @Override
    public void enqueue(final Callback<T> callback) {
        String query = mParams.encode();

        String url = mUrl;
        if (query != null) {
            if (url.contains("?")) { url = url + "&" + query;}
            else { url = url + "?" + query;}
        }

        mClient.get(url, mHeaders, mTag, shouldCache, callback);
    }
}
