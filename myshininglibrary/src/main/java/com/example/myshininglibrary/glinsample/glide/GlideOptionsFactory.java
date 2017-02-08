package com.example.myshininglibrary.glinsample.glide;

import android.content.Context;

//import com.haiersmart.utilslib.device.DeviceUtil;

import com.example.myshininglibrary.utilslib.device.DeviceUtil;

import java.util.HashMap;

/**
 * Created by qibin on 2016/7/28.
 */

public class GlideOptionsFactory {
    private static HashMap<Type, GlideOptions> mOptions;

    private GlideOptionsFactory() {}

    public static void init(Context ctx, int defLoading) {
        if (mOptions == null) {
            mOptions = new HashMap<>();
            mOptions.put(Type.DEFAULT, new GlideOptions(defLoading, 0));
            mOptions.put(Type.RADIUS, new GlideOptions(defLoading, DeviceUtil.dip2px(ctx,10)));
        }
    }

    public static GlideOptions get(Type type) {
        if (mOptions.containsKey(type)) {
            return mOptions.get(type);
        }

        throw new IllegalArgumentException();
    }

    public enum Type {
        DEFAULT (1), RADIUS (2);
        private int type;

        private Type(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "type:" + type;
        }
    }
}
