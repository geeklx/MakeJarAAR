package com.example.myshininglibrary.glinsample.juhenet;

import com.example.myshininglibrary.glin.Glin;
import com.example.myshininglibrary.glinsample.net.OkClient;

/**
 * Created by shining on 2017/2/10 0010.
 */

public class JuheNet {
    private static JuheNet sInstance;
    private Glin mGlin;

    public static JuheNet getsInstance() {
        return sInstance;
    }

    public static final void config(String url, String cacheDir) {
        sInstance = new JuheNet(url, cacheDir);
    }

    private JuheNet(String url, String cacheDir) {
        mGlin = new Glin.Builder()
                .client(new OkClient())
                .baseUrl(url)
                .timeout(5000)
                .debug(true)
                .parserFactory(new JuheParserFactory())
                .build();
    }

    public Glin get() {
        return mGlin;
    }

    public <T> T create(Class<T> convertClass, Object tag) {
        return get().create(convertClass, tag);
    }

    public static <T> T build(Class<T> convertClass, Object tag) {
        return getsInstance().create(convertClass, tag);
    }

}
