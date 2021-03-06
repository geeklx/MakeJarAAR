package com.example.shining.makejaraar.utils.glinutils;

import android.app.Activity;
import android.text.TextUtils;

import com.example.myshininglibrary.glin.Result;
import com.example.myshininglibrary.glin.interceptor.IResultInterceptor;
import com.example.myshininglibrary.glinsample.net.OkClient;
import com.example.myshininglibrary.utilslib.app.AppManager;
//import com.haiersmart.commonbizlib.net.Net;
//import com.haiersmart.commonbizlib.net.OkClient;
//import com.haiersmart.sfnation.api.ActivationApi;
//import com.haiersmart.sfnation.application.FridgeApplication;
//import com.haiersmart.sfnation.constant.ConstantUtil;
//import com.haiersmart.sfnation.dboper.status.FridgeCommonInfoStatus;
//import com.haiersmart.sfnation.domain.FridgeCommonInfo;
//import com.haiersmart.sfnation.domain.InitFridge;
//import com.haiersmart.sfnation.params.GetFridgeIDFamilyID;
//import com.haiersmart.sfnation.popwindows.PopLogin;
//import com.haiersmart.utilslib.app.AppManager;
//import com.haiersmart.utilslib.app.MyLogUtil;
//import com.haiersmart.utilslib.data.SpUtils;
//import com.haiersmart.utilslib.device.DeviceUtil;

//import org.loader.glin.Callback;
//import org.loader.glin.Result;
//import org.loader.glin.interceptor.IResultInterceptor;

//import cn.jpush.android.api.JPushInterface;

/**
 * Created by qibin on 2016/8/20.
 */

public class ResultInterceptor implements IResultInterceptor {

    public static final int TOKEN_NULL = 9998;
    public static final int TOKEN_INVALID = 9999;

    @Override
    public boolean intercept(Result<?> result) {
        if (!result.isOK()) {
            // check token
            Object obj = result.getObj();
            if (obj != null && TextUtils.isDigitsOnly(obj.toString())) {
                int code = Integer.parseInt(obj.toString());
//                if (code == TOKEN_INVALID && !UserUtils.isLogining()) {
//                    loginUtils.logout();
//                    Activity topActivity = AppManager.getInstance().top();
//                    if (topActivity != null && !topActivity.isFinishing()
//                            && !topActivity.isDestroyed()) {
//                        UserUtils.login(topActivity, null);
//                        return false;
//                    }
//                }
                if (code == TOKEN_INVALID ) {
                    Activity topActivity = AppManager.getInstance().top();
                    if (topActivity != null && !topActivity.isFinishing()
                            && !topActivity.isDestroyed()) {
                        return false;
                    }
                }
            }

            // check fridge_id
//            if (canRequest(result.getMessage()) && TextUtils.isEmpty(DataProvider.getFridge_id())) {
//                // 自动获取fridge_id
//                MyLogUtil.d("Glin", "has no fridge id, request for fridge id!!!");
//                requestFridgeAdd();
//            }
        }

        return false;
    }

    private boolean canRequest(String msg) {
        if (TextUtils.isEmpty(msg)) { return true;}
        if (msg.equals(OkClient.MSG_ERROR_HTTP)) { return false;}
        return true;
    }

    /**
     * 获取 FridgeId FamilyId
     */
    private void requestFridgeAdd() {
//        GetFridgeIDFamilyID getFridgeIDFamilyID = new GetFridgeIDFamilyID();
//        FridgeCommonInfo fci = FridgeCommonInfoStatus.getInstance().selectFridegCommonInfo();
//        getFridgeIDFamilyID.setFridge_mac(DeviceUtil.getMac(FridgeApplication.get()));
//        getFridgeIDFamilyID.setFridge_sn(fci.getSn());
//        getFridgeIDFamilyID.setFridge_model((String) SpUtils.getInstance(FridgeApplication.get()).get(ConstantUtil.FRIDGEMODE, "000"));
//        getFridgeIDFamilyID.setMain_board_sv(fci.getMain_board_sv());
//        getFridgeIDFamilyID.setSenser_board_hv(fci.getSenser_board_hv());
//        getFridgeIDFamilyID.setSenser_board_sv(fci.getSenser_board_sv());
//        getFridgeIDFamilyID.setElectric_board_hv(fci.getElectric_board_hv());
//        getFridgeIDFamilyID.setElectric_board_sv(fci.getElectric_board_sv());
//        getFridgeIDFamilyID.setMain_board_hv(fci.getMain_board_hv());
//
//        getFridgeIDFamilyID.setId_version(fci.getId_version());
//        getFridgeIDFamilyID.setProduct_serial(fci.getProduct_serial());
//        getFridgeIDFamilyID.setVonder_serial(fci.getVonder_serial());
//        getFridgeIDFamilyID.setJpush_id(JPushInterface.getRegistrationID(FridgeApplication.mContext));
//        getFridgeIDFamilyID.setApk_version(DeviceUtil.getVersionName(FridgeApplication.get()));
//        getFridgeIDFamilyID.setFridge_type(DataProvider.getFridge_type());
//
//        ActivationApi p = Net.build(ActivationApi.class, getClass().getName());
//        p.getFridgeIDFamilyID(ParamsUtils.just(getFridgeIDFamilyID)).enqueue(new Callback<InitFridge>() {
//            @Override
//            public void onResponse(Result<InitFridge> result) {
//                ShowLoadingUtil.dismissProgressDialog2();
//                if (result.isOK()) {
//                    SpUtils.getInstance(FridgeApplication.get()).put(ConstantUtil.FAMILY_ID, result.getResult().getFamily_id());
//                    DataProvider.setFamily_id(result.getResult().getFamily_id());
//                    SpUtils.getInstance(FridgeApplication.get()).put(ConstantUtil.FRIDGE_ID, result.getResult().getFridge_id());
//                    DataProvider.setFridge_id(result.getResult().getFridge_id());
//                }
//            }
//        });
    }
}