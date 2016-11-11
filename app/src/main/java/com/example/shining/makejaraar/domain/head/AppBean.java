package com.example.shining.makejaraar.domain.head;

//import com.haiersmart.sfnation.application.FridgeApplication;
//import com.haiersmart.sfnation.constant.ConstantUtil;
//import com.haiersmart.utilslib.data.ToStringUtil;
//import com.haiersmart.utilslib.device.DeviceUtil;

import com.example.myshininglibrary.utilslib.data.ToStringUtil;
import com.example.myshininglibrary.utilslib.device.DeviceUtil;
import com.example.shining.makejaraar.application.DemoApplication;

import java.io.Serializable;

/**
 * Created by jack_D on 2016/3/30.
 */
public class AppBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String app_id = "";
    private String version;
    private String user_id;

    public AppBean(String user_id) {
        //TODO 生成数据
        setApp_id(app_id);
        setVersion(DeviceUtil.getVersionName(DemoApplication.get()));
        if(user_id!=null){
            this.user_id=user_id;
        }else{
            this.user_id = "";
        }
    }


    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return ToStringUtil.getString(this);
    }
}
