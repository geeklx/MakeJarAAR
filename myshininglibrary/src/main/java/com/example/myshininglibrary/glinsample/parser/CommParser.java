package com.example.myshininglibrary.glinsample.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.myshininglibrary.glin.NetResult;
import com.example.myshininglibrary.glin.Result;
import com.example.myshininglibrary.glin.parser.Parser;

//import org.loader.glin.NetResult;
//import org.loader.glin.Result;
//import org.loader.glin.helper.Helper;
//import org.loader.glin.parser.Parser;

/**
 * Created by qibin on 2016/7/19. <br />
 * 解析json对象到java bean
 */

public class CommParser extends Parser {
    public CommParser(String key) {
        super(key);
    }

    @Override
    public <T> Result<T> parse(Class<T> klass, NetResult netResult) {
        Result<T> result = new Result<>();
        try {
            JSONObject baseObject = JSON.parseObject(netResult.getResponse());
            result = JsonParser.parseObject(baseObject, klass, mKey);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("数据获取失败");
        }
        return result;
    }
}
