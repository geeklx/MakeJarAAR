package com.example.myshininglibrary.glin.interceptor;


//import org.loader.glin.Result;

import com.example.myshininglibrary.glin.Result;

/**
 * Created by qibin on 2016/8/20.
 */

public interface IResultInterceptor {
    /**
     * 是否拦截结果
     * @param result
     * @return true callback不会执行
     */
    boolean intercept(Result<?> result);
}
