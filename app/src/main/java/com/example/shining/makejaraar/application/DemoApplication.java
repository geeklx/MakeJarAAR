package com.example.shining.makejaraar.application;

import android.content.Context;
import android.os.Environment;
import android.support.multidex.MultiDexApplication;

import com.example.myshininglibrary.glinsample.glide.GlideOptionsFactory;
import com.example.myshininglibrary.glinsample.juhenet.JuheNet;
import com.example.myshininglibrary.glinsample.net.Net;
import com.example.myshininglibrary.utilslib.app.MyLogUtil;
import com.example.myshininglibrary.utilslib.data.SpUtils;
import com.example.shining.makejaraar.R;
import com.example.shining.makejaraar.constant.ConstantNetUtil;
import com.example.shining.makejaraar.constant.ConstantUtil;
import com.example.shining.makejaraar.domain.head.AppBean;
import com.example.shining.makejaraar.domain.head.DataProvider_JIngtai;
import com.example.shining.makejaraar.domain.head.DeviceBean;
import com.example.shining.makejaraar.utils.glinutils.ResultInterceptor;


/**
 * Created by shining on 2016/11/10 0010.
 */

public class DemoApplication extends MultiDexApplication {
    private static final String TAG = "SFNationApplication";
    private static DemoApplication sInstance = null;
    public static Context mContext;

    public static DemoApplication get() {
        if (sInstance == null) {
            sInstance = new DemoApplication();
        }
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mContext = getApplicationContext();
        MyLogUtil.setLogEnable(true);
        //初始化网络请求bufen
        Net.config(ConstantNetUtil.URL_IOT,
                Environment.getExternalStorageDirectory() + ConstantUtil.DIR_DATA_CACHE,
                new ResultInterceptor());
        JuheNet.config(ConstantNetUtil.SERVER_JUHE,
                Environment.getExternalStorageDirectory() + ConstantUtil.DIR_DATA_CACHE);
//        Net.config(ConstantNetUtil.URL_IOT, new ResultInterceptor());
        //初始化Glidebufen
        GlideOptionsFactory.init(this, R.mipmap.ic_launcher);
        //初始化请求headbufen
        setAPPandDeviceInfo();

    }

    private void setAPPandDeviceInfo() {
        String userId = (String) SpUtils.getInstance(this).get(ConstantUtil.USER_ID, "");
        this.setAPPandDeviceInfo(mContext, userId);
    }

    public static void setAPPandDeviceInfo(Context mContext, String userId) {
        DataProvider_JIngtai.app = new AppBean(userId);
        DataProvider_JIngtai.device = new DeviceBean(mContext);
    }
}
