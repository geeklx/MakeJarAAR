package com.example.myshininglibrary.glinsample.juhenet;

import com.alibaba.fastjson.JSON;
import com.example.myshininglibrary.glin.NetResult;
import com.example.myshininglibrary.glin.Result;
import com.example.myshininglibrary.glin.parser.Parser;

/**
 * Created by shining on 2017/2/9 0009.
 */

public class JuheListParser extends Parser {

    @Override
    public <T> Result<T> parse(Class<T> klass, NetResult netResult) {
        Result<T> result = new Result<T>();
        result.setCode(netResult.getStatusCode());
        result.setObj(result.getCode());
        result.setMessage(netResult.getMessage());
        try {
            T res = (T) JSON.parseArray(netResult.getResponse(), klass);
            result.setResult(res);
            result.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.ok(false);
        }

        return result;
    }
}
