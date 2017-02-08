package com.example.shining.makejaraar.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myshininglibrary.glinsample.net.Net;
import com.example.myshininglibrary.utilslib.app.ViewHelper;
import com.example.shining.makejaraar.utils.IMEUtil;
import com.example.shining.makejaraar.utils.loginutils.UserUtils;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;

//import com.haiersmart.commonbizlib.net.Net;
//import com.haiersmart.sfnation.bizutils.UserUtils;
//import com.haiersmart.sfnation.widget.IMEUtil;
//import com.haiersmart.utilslib.app.ViewHelper;

/**
 * Created by qibin on 2016/7/21.
 */

public abstract class BaseFragment extends Fragment {

    public final String TAG = getClass().getSimpleName().toString();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        if (autoHideIME()) { rootView = IMEUtil.wrap(rootView);}
        ButterKnife.bind(this, rootView);
        setup(rootView, savedInstanceState);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(TAG);
    }

    protected void setup(View rootView, @Nullable Bundle savedInstanceState) {

    }

    protected <T extends View> T f(View rootView, @IdRes int resId) {
        return ViewHelper.f(rootView, resId);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(getActivity(), activity));
    }

    public void startActivityForResult(Class<? extends Activity> activity, int requestCode) {
        startActivityForResult(new Intent(getActivity(), activity), requestCode);
    }

    /**
     * 跳转到指定activity，如果未登录，则弹出登录窗口
     * @param activity
     */
    public void targetToIfLogin(final Class<? extends BaseActivity> activity) {
        UserUtils.loginToDo(getActivity(), new Runnable() {
            @Override
            public void run() { startActivity(activity);}
        });
    }

    /**
     * 跳转到指定activity，如果未登录，则弹出登录窗口
     * @param intent
     */
    public void targetToIfLogin(final Intent intent) {
        UserUtils.loginToDo(getActivity(), new Runnable() {
            @Override
            public void run() { startActivity(intent);}
        });
    }

    /**
     * 跳转到指定activity，如果未登录，则弹出登录窗口
     * @param intent
     */
    public void targetToForResultIfLogin(final Intent intent, final int requestCode) {
        UserUtils.loginToDo(getActivity(), new Runnable() {
            @Override
            public void run() { startActivityForResult(intent, requestCode);}
        });
    }

    protected abstract int getLayoutId();

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(TAG);
    }

    @Override
    public void onDestroy() {
        Net.getInstance().get().cancel(getClass().getName());
        super.onDestroy();
    }

    protected boolean autoHideIME() {
        return false;
    }
}
