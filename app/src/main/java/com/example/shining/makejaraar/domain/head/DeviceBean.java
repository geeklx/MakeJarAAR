package com.example.shining.makejaraar.domain.head;

import android.content.Context;

import com.example.myshininglibrary.utilslib.data.ToStringUtil;
import com.example.myshininglibrary.utilslib.device.DeviceUtil;
import com.example.shining.makejaraar.application.DemoApplication;
import com.example.shining.makejaraar.constant.ConstantUtil;

import java.io.Serializable;

//import com.haiersmart.sfnation.application.FridgeApplication;
//import com.haiersmart.sfnation.constant.ConstantUtil;
//import com.haiersmart.utilslib.data.ToStringUtil;
//import com.haiersmart.utilslib.device.DeviceUtil;

/**
 * Created by jack_D on 2016/3/30.
 */
public class DeviceBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String platform;
    private String model;
    private String factory;
    private String screen_size;
    private String denstiy;
    private String imei;
    private String mac;
    private String gprs;
    private double latitude;
    private double longitude;

    public DeviceBean(Context context) {
        setPlatform(ConstantUtil.PLATFORM);
        setModel(DeviceUtil.getModel());
        setFactory(DeviceUtil.getFactory());
        setScreen_size(DeviceUtil.SCREEN_WIDTH + "*" + DeviceUtil.SCREEN_HEIGHT);
        setDenstiy("" + DeviceUtil.getDenstiy(DemoApplication.get()));
//        setIMEI(DeviceUtil.getImei());
//        setMac(DeviceUtil.getMac());

        setImei(DeviceUtil.getImei(context));
        setMac(DeviceUtil.getLocalMacAddress(context));
        setGprs("4G");
        setLatitude(39.981077D);
        setLongitude(116.497064);

    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(String screen_size) {
        this.screen_size = screen_size;
    }

    public String getDenstiy() {
        return denstiy;
    }

    public void setDenstiy(String denstiy) {
        this.denstiy = denstiy;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getGprs() {
        return gprs;
    }

    public void setGprs(String gprs) {
        this.gprs = gprs;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return ToStringUtil.getString(this);
    }
}
