package com.example.shining.makejaraar.api;


import com.example.myshininglibrary.glin.annotation.JSON;
import com.example.myshininglibrary.glin.call.Call;
import com.example.shining.makejaraar.domain.login.LoginSumitModel;

import static com.example.shining.makejaraar.constant.ConstantNetUtil.URL_USER;


/**
 * Created by shining 2016年11月14日18:46:34
 */

public interface LoginApi {

    //获取登录验证码部分
    @JSON(URL_USER + "user/user.register.vercode.get")
    Call<Object> login(String json);

    //手机验证码登录部分
    @JSON(URL_USER + "user/user.logout")
    Call<Object> loginOut(String json);

    //手机验证码登录部分
    @JSON(URL_USER + "user/user.vercode.login.check")
    Call<LoginSumitModel> loginSubmit(String json);

    /**
     * 快速登录 验证码
     *
     * @param json
     * @return
     */
    @JSON(URL_USER + "user/user.quick.login.vercode")
    Call<Object> quickLoginVercode(String json);

    /**
     * 快速登录 登录
     *
     * @param json
     * @return
     */
    @JSON(URL_USER + "user/user.quick.login")
    Call<LoginSumitModel> quickLogin(String json);
}