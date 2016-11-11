package com.example.myshininglibrary.glin.parser;

//import org.loader.glin.NetResult;
//import org.loader.glin.Result;

import com.example.myshininglibrary.glin.NetResult;
import com.example.myshininglibrary.glin.Result;

/**
 * Created by qibin on 2016/7/13.
 */

public abstract class Parser {
    public String mKey;

    public Parser() {

    }

    public Parser(String key) {
        mKey = key;
    }

    /**
     *
     * @param klass the class of {@code Callback}
     * @param netResult
     * @param <T>
     * @return
     */
    public abstract <T> Result<T> parse(Class<T> klass, NetResult netResult);
}
