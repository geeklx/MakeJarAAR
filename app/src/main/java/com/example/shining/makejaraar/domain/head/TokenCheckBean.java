package com.example.shining.makejaraar.domain.head;

import com.alibaba.fastjson.JSONObject;
import com.example.shining.makejaraar.constant.ConstantUtil;

import java.util.Date;

//import com.haiersmart.sfnation.constant.ConstantUtil;
//import com.haiersmart.utilslib.data.MD5Util;

public class TokenCheckBean {
    private String access_token;
    private String timestamp;
    private String sign;
    private String client_id;
    private String sequence_id;
    private String language = "zh-cn";
    private String timezone = "8";

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getSequence_id() {
        return DataProvider.getSequence_id();
    }

    public String getSequence_id(long time) {
        return DataProvider.getSequence_id(time);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public TokenCheckBean(JSONObject data) {
        long time = (new Date()).getTime();
        String body = data.toString();
        body = body.replaceAll("", "");
        body = body.replaceAll("\t", "");
        body = body.replaceAll("\r", "");
        body = body.replaceAll("\n", "");
        String toSign = body + ConstantUtil.APP_ID + ConstantUtil.APP_KEY + time;
        //TODO 生成sign
        this.sign = "0fd81567ed97aa396079acc7b18c865c";//MD5Util.getMD5String(toSign)
        this.access_token = "";//DataProvider.getAccess_token()
        this.timestamp = "1420129567535";//time+""
        this.client_id = "78:64:e6:17:76:fd";//DataProvider.device.getMac()
        this.sequence_id = "14201295675380000066";//getSequence_id(time)
        this.language = "zh-cn";
        this.timezone = "8";
    }
}