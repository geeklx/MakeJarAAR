package com.example.shining.makejaraar.utils.loadingutils;

import android.content.Context;
import android.os.Handler;

import com.example.shining.makejaraar.widget.loading.MaterialProgress.MaterialProgressDialog;


/**
 * Created by shining 2016年11月11日16:01:46
 */
public class MaterialProgressLoadingUtil {
    public static MaterialProgressDialog mProgressDialog;//loading样式2
    private static final long AUTO_DISMISS_TIME = 5000;
    private static Handler disHandler = new Handler();
    private static Thread disThread = new Thread(new Runnable() {
        @Override
        public void run() {
            dismissProgressDialog();
        }
    });

    /**
     * @description: 显示ProgressDialog
     */
    public static boolean showProgressDialog(Context context, String progressDesc) {
        if (progressDesc != null && !"".equals(progressDesc)) {

            if (mProgressDialog == null) {
                mProgressDialog = new MaterialProgressDialog(context);
                //TODO 控制loading下面的字
                mProgressDialog.setLoadingText(progressDesc);
                mProgressDialog.setCanceledOnTouchOutside(false);
//                mProgressDialog.setCancelable(false);
                mProgressDialog.show();
            } else {
                mProgressDialog.show();
            }
            disHandler.postDelayed(disThread, AUTO_DISMISS_TIME);
//            mHandler.postDelayed(dismisRun,10*1000);
            return true;
        } else {
            disHandler.postDelayed(disThread, AUTO_DISMISS_TIME);
            return false;
        }
//        return true;
    }

    /***
     * @return true取消成功 false 加载框不存在
     * @description: 取消加载框
     */
    public static boolean dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
            disHandler.removeCallbacks(disThread);
            return true;
        } else {
            disHandler.removeCallbacks(disThread);
            return false;
        }
//        return true;
    }


}