
package com.example.shining.makejaraar.login;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.example.myshininglibrary.glin.Callback;
import com.example.myshininglibrary.glin.Result;
import com.example.myshininglibrary.glinsample.net.Net;
import com.example.myshininglibrary.utilslib.data.SpUtils;
import com.example.shining.makejaraar.R;
import com.example.shining.makejaraar.api.LoginApi;
import com.example.shining.makejaraar.application.DemoApplication;
import com.example.shining.makejaraar.constant.ConstantUtil;
import com.example.shining.makejaraar.domain.head.DataProvider;
import com.example.shining.makejaraar.domain.login.LoginSumitModel;
import com.example.shining.makejaraar.utils.glinutils.ParamsUtils;
import com.example.shining.makejaraar.utils.loadingutils.ShapeLoadingUtil;
import com.example.shining.makejaraar.utils.toastutils.ToastUtil;
//import com.haiersmart.commonbizlib.net.Net;
//import com.haiersmart.sfnation.R;
//import com.haiersmart.sfnation.api.LoginApi;
//import com.haiersmart.sfnation.application.FridgeApplication;
//import com.haiersmart.sfnation.bizutils.DataProvider;
//import com.haiersmart.sfnation.bizutils.ParamsUtils;
//import com.haiersmart.sfnation.bizutils.ShowLoadingUtil;
//import com.haiersmart.sfnation.bizutils.ToastUtil;
//import com.haiersmart.sfnation.constant.ConstantUtil;
//import com.haiersmart.sfnation.domain.LoginSumitModel;
//import com.haiersmart.sfnation.ui.mine.MineActivity;
//import com.haiersmart.utilslib.data.SpUtils;
//
//import org.loader.glin.Callback;
//import org.loader.glin.Result;
//
//import cn.jpush.android.api.JPushInterface;


public class PopLogin extends PopupWindow implements TextWatcher {
    private Button btn_ok, btn_cancel;
    private TextView tv_dialog_title;
    private EditText ed_sjh;
    private EditText ed_qsryzm;
    private TextView tv_hqyzm;
    private Activity mActivity;

    private View mMenuView;
    private boolean isTag = false;
    private static boolean isLogining;

    private PopLogin() {

    }

    @SuppressWarnings("deprecation")
    public PopLogin(final Activity mActivity, final OnLoginListener li) {
        super(mActivity);
        this.mActivity = mActivity;
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        LayoutInflater inflater = (LayoutInflater) mActivity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.pop_loginin, null);

        tv_dialog_title = (TextView) mMenuView.findViewById(R.id.tv_dialog_title);
        ed_sjh = (EditText) mMenuView.findViewById(R.id.ed_sjh);

        btn_ok = (Button) mMenuView.findViewById(R.id.btn_ok);
        btn_ok.setEnabled(false);
        btn_ok.setBackgroundResource(R.drawable.smssdk_btn_disenable);
        btn_cancel = (Button) mMenuView.findViewById(R.id.btn_cancel);
        ed_qsryzm = (EditText) mMenuView.findViewById(R.id.ed_qsryzm);
        tv_hqyzm = (TextView) mMenuView.findViewById(R.id.tv_hqyzm);
        tv_hqyzm.setEnabled(false);
        tv_hqyzm
                .setBackgroundResource(R.drawable.smssdk_btn_disenable_hqyzm);
        ed_sjh.setText("");
        ed_sjh.requestFocus();
        ed_sjh.addTextChangedListener(this);
        //设置按钮监听1 确定
        btn_ok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = ed_sjh.getText().toString().trim();
                String verCode = ed_qsryzm.getText().toString().trim();
                if (!isPhone(phone)) {
                    return;
                }
                if (!isVer(verCode)) {
                    return;
                }

                ShapeLoadingUtil.showProgressDialog(mActivity,
                        mActivity.getResources().getString(R.string.loading));
                if ("5002".equals(DataProvider.getStatus_code())) {
                    requestQuickLogin(li);
                } else /*if (mStatusCode == 5001)*/ {
                    requestLogin(li);
                }
                DataProvider.setStatus_code("0");
                threadcheckout();
                hideInputMethod(mActivity);
            }

        });
        //设置按钮监听2 取消
        btn_cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 事件回调
                ed_sjh.setText("");
                ed_qsryzm.setText("");
                threadcheckout();
                dismiss();
                hideInputMethod(mActivity);
                //TODO 灭屏状态
//                FridgeApplication.getInstance().screenLightUpRelease();
                isLogining = false;
            }
        });
        //设置按钮监听3 验证码
        tv_hqyzm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 事件回调
                // 刷新
                isTag = true;
                String phone = ed_sjh.getText().toString().trim();
                if (!isPhone(phone)) {
                    return;
                }
                if (tv_hqyzm.getText().toString().equals(mActivity.getResources().getString(R.string.pop_login_hqyzm))) {
                    //获取验证码
                    ShapeLoadingUtil.showProgressDialog(mActivity, mActivity.getResources().getString(
                            R.string.loading));
                    doNetWorkVerificationCode();
                } else {
                    //重试
                    threadcheckout();
                    isTag = true;
                    doNetWorkVerificationCode();
                }

            }
        });
//        btn_cancel.setOnClickListener(itemsOnClick);
        // 设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.FILL_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.FILL_PARENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimBottom);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                hideInputMethod(mActivity);
                return true;
            }
        });

    }

    private boolean isPhone(String phone) {
        if (TextUtils.isEmpty(phone)) {
            ToastUtil.showToastShort("请输入您的手机号码！");
            return false;
        }

        if (!TextUtils.isDigitsOnly(phone)) {
            ToastUtil.showToastShort("手机号格式错误，仅支持纯数字！");
            return false;
        }

        if (phone.length() != 11) {
            ToastUtil.showToastShort("手机号格式错误，应为11位纯数字！");
            return false;
        }

        return true;
    }

    private boolean isVer(String str) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.showToastShort("请输入短信验证码！");
            return false;
        }

        return true;
    }

    @Override
    public void setOnDismissListener(OnDismissListener onDismissListener) {
        hideInputMethod(mActivity);
        super.setOnDismissListener(onDismissListener);
    }

    public void hideInputMethod(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mMenuView, InputMethodManager.SHOW_FORCED);
        imm.hideSoftInputFromWindow(mMenuView.getWindowToken(), 0); //强制隐藏键盘

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (ed_sjh.getText().toString().trim().equals("")) {
            tv_hqyzm.setText(mActivity.getResources().getString(R.string.pop_login_hqyzm));
        }

        if (s.length() > 0) {
            btn_ok.setEnabled(true);
            btn_ok.setBackgroundResource(R.drawable.pop_login_ok_bg);
            tv_hqyzm.setEnabled(true);
            tv_hqyzm.setBackgroundResource(R.drawable.smssdk_btn_enable_hqyzm);
        } else {
            btn_ok.setEnabled(false);
            btn_ok.setBackgroundResource(R.drawable.smssdk_btn_disenable);
            tv_hqyzm.setEnabled(false);
            tv_hqyzm.setBackgroundResource(R.drawable.smssdk_btn_disenable_hqyzm);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    /**
     * 请求数据 获取验证码
     */
    private void doNetWorkVerificationCode() {
        String mobile = ed_sjh.getText().toString().trim();
        JSONObject p = new JSONObject();
        p.put("phone", mobile);
        Net.build(LoginApi.class, getClass().getName()).quickLoginVercode(ParamsUtils.just(p))
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Result<Object> result) {
                        ShapeLoadingUtil.dismissProgressDialog();
                        if (!result.isOK()) {
                            ToastUtil.showToastLong(result.getMessage());
                            return;
                        }

                        Object obj = result.getObj();
                        if (obj != null) {
                            DataProvider.setStatus_code(obj.toString());
                            ToastUtil.showToastLong(mActivity.getResources().getString(R.string.pop_login_sendsuccess));
                            countDown();
                        }
                    }
                });
    }

    /**
     * 已注册， 登录
     */
    private void requestLogin(final OnLoginListener li) {
        JSONObject p = new JSONObject();
        p.put("login_name", ed_sjh.getText().toString().trim());
        p.put("vercode", ed_qsryzm.getText().toString().trim());
//        p.put("registration_id", JPushInterface.getRegistrationID(mActivity));//获取jpushidbufen
        p.put("device_token", "");
        p.put("family_id", DataProvider.getFamily_id());
        p.put("fridge_id", DataProvider.getFridge_id());
        Net.build(LoginApi.class, getClass().getName()).loginSubmit(ParamsUtils.just(p)).enqueue(new Callback<LoginSumitModel>() {
            @Override
            public void onResponse(Result<LoginSumitModel> result) {
                isLogining = false;
                ShapeLoadingUtil.dismissProgressDialog();
                if (!result.isOK()) {
                    onFailed(result);
                    if (li != null) {
                        li.onLogin(false);
                    }
                    return;
                }
                onResult(li, result.getResult());
            }
        });
    }

    /**
     * 请求数据 未注册， 快速登录
     */
    private void requestQuickLogin(final OnLoginListener li) {
        JSONObject p = new JSONObject();
        p.put("phone", ed_sjh.getText().toString().trim());
        p.put("vercode", ed_qsryzm.getText().toString().trim());
        p.put("family_id", DataProvider.getFamily_id());
        p.put("fridge_id", DataProvider.getFridge_id());
        Net.build(LoginApi.class, getClass().getName()).quickLogin(ParamsUtils.just(p))
                .enqueue(new Callback<LoginSumitModel>() {
                    @Override
                    public void onResponse(Result<LoginSumitModel> result) {
                        isLogining = false;
                        ShapeLoadingUtil.dismissProgressDialog();
                        if (!result.isOK()) {
                            onFailed(result);
                            if (li != null) {
                                li.onLogin(false);
                            }
                            return;
                        }

                        onResult(li, result.getResult());
                    }
                });
    }

    private void onFailed(Result<LoginSumitModel> result) {
        Object obj = result.getObj();
        int code = 0;
        if (obj != null && TextUtils.isDigitsOnly(obj.toString())) {
            code = Integer.parseInt(obj.toString());
        }

        switch (code) {
            case 5003:
            case 5004:
            case 5005:
            case 5006:
            case 5007:
            case 5008:
            case 5009:
            case 5010:
                ToastUtil.showToastShort(result.getMessage());
                break;
            default:
                String msg = result.getMessage();
                if (msg != null && msg.contains("对象不存在")) {
                    ToastUtil.showToastShort("验证码无效！");
                    break;
                }

                ToastUtil.showToastShort(R.string.network_error);
                break;
        }
    }

    private void onResult(final OnLoginListener li, LoginSumitModel res) {
        if (res == null) {
            return;
        }

        DataProvider.setUser_id(res.getUser_id());
        DataProvider.setAccess_token(res.getAccess_token());
        DataProvider.setU_id(res.getU_open_id());

        SpUtils.getInstance(DemoApplication.get()).put(ConstantUtil.USER_ID, res.getUser_id());
        SpUtils.getInstance(DemoApplication.get()).put(ConstantUtil.ACCESS_TOKEN, res.getAccess_token());
        SpUtils.getInstance(DemoApplication.get()).put(ConstantUtil.BINDINGPHONE, ed_sjh.getText().toString().trim());
        SpUtils.getInstance(DemoApplication.get()).put(ConstantUtil.U_ID, res.getU_open_id());

        ToastUtil.showToastLong(mActivity.getResources().getString(R.string.pop_login_success));
        //判断当前是否为MineActivity显示数据bufen
//        if (mActivity instanceof MineActivity) {
//
//            ((MineActivity) mActivity).getHeaderInfo(res.getUser_id());
//            ((MineActivity) mActivity).getWalletMoney(res.getUser_id());
//
//        }

        dismiss();
        if (li != null) {
            li.onLogin(true);
        }
    }

    /**
     * 关闭线程部分
     */
    private void threadcheckout() {
        time = UPDATE_TIME;
        if (thread != null) {
            mhandler.removeMessages(1);
            thread.interrupt();
            thread = null;
            isTag = false;
        }
    }

    private static final int UPDATE_TIME = 60;
    private int time = UPDATE_TIME;

    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (time > 0 && isFragmentOn) {
                        // 接收短信大约需要60seconds
                        String unReceive = time + "秒";
                        // 刷新
                        updaTvunReceive1(unReceive);
                        time--;
                    } else {
                        isTag = false;
                        String unReceive = mActivity.getResources().getString(
                                R.string.smssdk_unreceive_identify_code1);
                        if (isFragmentOn) {
                            updaTvunReceive2(unReceive);
                        }
                        time = UPDATE_TIME;
                    }
                    break;
                default:
                    break;
            }
        }
    };
    Thread thread;
    private boolean isFragmentOn = true;

    /**
     * 读秒部分
     */
    private void countDown() {
        if (thread == null) {
            thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        while (isTag && isFragmentOn) {
                            mhandler.sendEmptyMessage(1);
                            sleep(1000);
                        }
                        if (!isFragmentOn) {
                            time = UPDATE_TIME;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }


    /**
     * 刷新操作1
     *
     * @param unReceive
     */

    private void updaTvunReceive1(final String unReceive) {
        tv_hqyzm.setText(Html.fromHtml(unReceive));
        tv_hqyzm.setEnabled(false);
        tv_hqyzm
                .setBackgroundResource(R.drawable.smssdk_btn_disenable_hqyzm);
        ed_sjh.setEnabled(false);
    }

    /**
     * 刷新操作2
     *
     * @param unReceive
     */

    private void updaTvunReceive2(final String unReceive) {
        tv_hqyzm.setText(Html.fromHtml(unReceive));
        tv_hqyzm.setEnabled(true);
        tv_hqyzm.setBackgroundResource(R.drawable.smssdk_btn_enable_hqyzm);
        ed_sjh.setEnabled(true);
    }

    public static void showLoginDialog(Activity activity, OnLoginListener li) {
        PopLogin login = new PopLogin(activity, li);
        login.showAtLocation(activity.getWindow().getDecorView(),
                Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL
                , 0, 0);
        isLogining = true;
    }

    public static boolean isLogining() {
        return isLogining;
    }

    public interface OnLoginListener {
        void onLogin(boolean success);
    }
}
