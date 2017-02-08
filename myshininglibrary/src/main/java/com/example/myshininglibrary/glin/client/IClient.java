package com.example.myshininglibrary.glin.client;

//import org.loader.glin.client.IRequest;
//import org.loader.glin.factory.ParserFactory;
//import org.loader.glin.interceptor.IResultInterceptor;

import com.example.myshininglibrary.glin.cache.ICacheProvider;
import com.example.myshininglibrary.glin.factory.ParserFactory;
import com.example.myshininglibrary.glin.interceptor.IResultInterceptor;

import java.util.LinkedHashMap;

/**
 * Created by qibin on 2016/7/13.
 */
public interface IClient extends IRequest {
    void cancel(final Object tag);
    void parserFactory(ParserFactory factory);
    LinkedHashMap<String, String> headers();
    void resultInterceptor(IResultInterceptor interceptor);
    void cacheProvider(ICacheProvider provider);
    void timeout(long ms);
    void debugMode(boolean debug);
}
