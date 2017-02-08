package com.example.shining.makejaraar.utils.loginutils;

import android.app.Activity;
import android.text.TextUtils;

import com.example.myshininglibrary.utilslib.data.SpUtils;
import com.example.shining.makejaraar.application.DemoApplication;
import com.example.shining.makejaraar.constant.ConstantUtil;
import com.example.shining.makejaraar.domain.head.DataProvider;
import com.example.shining.makejaraar.login.PopLogin;

//import com.haiersmart.sfnation.popwindows.PopLogin;
//import com.haiersmart.utilslib.data.SpUtils;

/**
 * Created by shining 2016年11月14日18:00:28
 */

public class UserUtils {

    public static boolean isUserLogin() {
        // step 1 判断内存中是否有user_id
        if (!TextUtils.isEmpty(DataProvider.getUser_id())) {
            return true;
        }

        // step 2 如果内存中没有， 则去文件中找
        String uid = (String) SpUtils.getInstance(DemoApplication.get()).get(ConstantUtil.USER_ID, null);

        // step 3 如果文件中有， 则提到内存中
        if (!TextUtils.isEmpty(uid)) {
            DataProvider.setUser_id(uid);
            return true;
        }

        // 未登录
        return false;
    }

    /**
     * 需要登录的操作
     *
     * @param runnable
     */
    public static void loginToDo(Activity activity, final Runnable runnable) {
        if (isUserLogin()) {
            runnable.run();
            return;
        }

        PopLogin.showLoginDialog(activity, new PopLogin.OnLoginListener() {
            @Override
            public void onLogin(boolean success) {
                if (success) {
                    runnable.run();
                }
            }
        });
    }
}
