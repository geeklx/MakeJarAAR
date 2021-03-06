package com.example.shining.makejaraar.api;


import com.example.myshininglibrary.glin.annotation.JSON;
import com.example.myshininglibrary.glin.call.Call;
import com.example.shining.makejaraar.domain.DemoWeatherModel;

import static com.example.shining.makejaraar.constant.ConstantNetUtil.URL_IOT;


/**
 * Created by shining on 2016/11/10 0010.
 */

public interface DemoApi {
    //获取model接口bufen
    @JSON(URL_IOT + "weather/weather.get.info")
    Call<DemoWeatherModel> getDemoModel(String json);
}
