package com.example.myshininglibrary.glin.factory;


import com.example.myshininglibrary.glin.annotation.DEL;
import com.example.myshininglibrary.glin.annotation.GET;
import com.example.myshininglibrary.glin.annotation.JSON;
import com.example.myshininglibrary.glin.annotation.POST;
import com.example.myshininglibrary.glin.annotation.PUT;
import com.example.myshininglibrary.glin.call.Call;
import com.example.myshininglibrary.glin.call.DelCall;
import com.example.myshininglibrary.glin.call.GetCall;
import com.example.myshininglibrary.glin.call.JsonCall;
import com.example.myshininglibrary.glin.call.PostCall;
import com.example.myshininglibrary.glin.call.PutCall;

import java.lang.annotation.Annotation;
import java.util.HashMap;

/**
 * Created by qibin on 2016/7/13.
 */

public class CallFactory {

    private HashMap<Class<? extends Annotation>, Class<? extends Call>> mMapping = new HashMap<>();

    public CallFactory() {
        autoRegist();
    }

    private void autoRegist() {
        regist(JSON.class, JsonCall.class);
        regist(GET.class, GetCall.class);
        regist(POST.class, PostCall.class);
        regist(PUT.class, PutCall.class);
        regist(DEL.class, DelCall.class);
    }

    public void regist(Class<? extends Annotation> key, Class<? extends Call> value) {
        mMapping.put(key, value);
    }

    public Class<? extends Call> get(Class<? extends Annotation> key) {
        return mMapping.get(key);
    }

    public HashMap<Class<? extends Annotation>, Class<? extends Call>> get() {
        return mMapping;
    }
}
