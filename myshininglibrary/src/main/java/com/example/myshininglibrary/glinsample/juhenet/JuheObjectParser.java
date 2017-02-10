package com.example.myshininglibrary.glinsample.juhenet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.myshininglibrary.glin.NetResult;
import com.example.myshininglibrary.glin.Result;
import com.example.myshininglibrary.glin.parser.Parser;

/**
 * Created by shining on 2017/2/9 0009.
 */

public class JuheObjectParser extends Parser {
    @Override
    public <T> Result<T> parse(Class<T> klass, NetResult netResult) {
        Result<T> result = new Result<T>();
        try {
            JSONObject baseObject = JSON.parseObject(netResult.getResponse());
            result.setCode(baseObject.getIntValue("error_code"));
            result.setMessage(baseObject.getString("reason"));
            result.ok(result.getCode() == 0);

            T res = JSON.parseObject(netResult.getResponse(), klass);
            result.setResult(res);
            result.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.ok(false);
        }
        return result;
    }
}
