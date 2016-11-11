package com.example.myshininglibrary.glinsample.net;

//import com.haiersmart.commonbizlib.parser.FastJsonParserFactory;

//import org.loader.glin.Callback;
//import org.loader.glin.Glin;
//import org.loader.glin.call.Call;
//import org.loader.glin.factory.ParserFactory;
//import org.loader.glin.interceptor.IResultInterceptor;

import com.example.myshininglibrary.glin.Glin;
import com.example.myshininglibrary.glin.interceptor.IResultInterceptor;
import com.example.myshininglibrary.glinsample.parser.FastJsonParserFactory;

/**
 * Created by qibin on 2016/7/19. <br />
 * 网络请求
 */

public class Net {

    private static Net sInstance;
    private Glin mGlin;

    public static final void config(String url, IResultInterceptor resultInterceptor) {
        sInstance = new Net(url, resultInterceptor);
    }

    private Net(String url, IResultInterceptor resultInterceptor) {
        mGlin = new Glin.Builder()
                .client(new OkClient())
                .baseUrl(url)
                .timeout(5 * 1000)
                .debug(true)
                .parserFactory(new FastJsonParserFactory())
                .resultInterceptor(resultInterceptor)
                .build();
    }

    public static Net getInstance() {
        return sInstance;
    }

    /**
     * 获取网络框架
     *
     * @return
     */
    public Glin get() {
        return mGlin;
    }

    /**
     * 创建一个业务请求
     *
     * @param convertClass 业务请求接口的class
     * @param tag          本次网络请求的tag
     * @return
     */
    public <T> T create(Class<T> convertClass, Object tag) {
        return get().create(convertClass, tag);
    }

    /**
     * 创建一个业务请求 <br />
     * {@link Net#create}方法的静态封装
     *
     * @param convertClass 业务请求接口的class
     * @param tag          本次网络请求的tag
     * @return
     */
    public static <T> T build(Class<T> convertClass, Object tag) {
        return getInstance().create(convertClass, tag);
    }
}
