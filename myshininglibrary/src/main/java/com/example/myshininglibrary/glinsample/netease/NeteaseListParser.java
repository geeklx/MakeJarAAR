package com.example.myshininglibrary.glinsample.netease;

import com.alibaba.fastjson.JSON;
import com.example.myshininglibrary.glin.NetResult;
import com.example.myshininglibrary.glin.Result;
import com.example.myshininglibrary.glin.parser.Parser;


/**
 * <p>function: </p>
 * <p>description:  </p>
 * <p>history:  1. 2016/12/19</p>
 * <p>Author: qibin</p>
 * <p>modification:</p>
 */
public class NeteaseListParser extends Parser {

    @Override
    public <T> Result<T> parse(Class<T> klass, NetResult netResult) {
        Result<T> result = new Result<>();
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
