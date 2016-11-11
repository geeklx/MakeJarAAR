package com.example.shining.makejaraar.utils;


import com.example.myshininglibrary.utilslib.data.StringUtil;
import com.example.shining.makejaraar.R;

/**
 * Created by geek on 2016/7/21.
 */

public class NetErrorCheck {

    public static boolean checkContent(String content) {
        if (StringUtil.isEmpty(content)) { return false;}
        String lowerContent = content.toLowerCase();
        if (lowerContent.equals("canceled")) { return false;}
        if (lowerContent.contains("okhttp")) { return false;}
        if (lowerContent.contains("java")) { return false;}
//        if (lowerContent.contains("token")) { return false;}
        if (lowerContent.contains("null")) { return false;}
        if (lowerContent.contains("hostname") || (lowerContent.contains("failed")
                && lowerContent.contains("connect"))
                || lowerContent.contains("timeout")) {
            ToastUtil.showToastShort(R.string.network_error);
            return false;
        }
        // more ...

        return true;
    }
}
