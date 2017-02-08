package com.example.myshininglibrary.glinsample.netease;


import com.example.myshininglibrary.glin.Glin;
import com.example.myshininglibrary.glinsample.net.Net;
import com.example.myshininglibrary.glinsample.net.OkClient;

/**
 * <p>function: </p>
 * <p>description:  </p>
 * <p>history:  1. 2016/12/19</p>
 * <p>Author: qibin</p>
 * <p>modification:</p>
 */
public class NeteaseNet {
    private static NeteaseNet sInstance;
    private Glin mGlin;

    public static final void config(String url, String cacheDir) {
        sInstance = new NeteaseNet(url, cacheDir);
    }

    private NeteaseNet(String url, String cacheDir) {
        mGlin = new Glin.Builder()
                .client(new OkClient())
                .baseUrl(url)
                .timeout(5 * 1000)
                .debug(true)
                .parserFactory(new NeteaseParserFactory())
                .build();
    }

    public static NeteaseNet getInstance() {
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
