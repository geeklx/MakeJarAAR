package com.example.shining.makejaraar.utils.loadingutils;

import android.content.Context;
import android.os.Handler;

import com.example.shining.makejaraar.widget.loading.SimpleLoadingDialogView;


/**
 * Created by shining 2016年11月11日16:01:46
 */
public class SimpleLoadingUtil {
    public static SimpleLoadingDialogView simpleLoadingDialog;//loading样式2
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

            if (simpleLoadingDialog == null) {
                simpleLoadingDialog = new SimpleLoadingDialogView(context);
                //TODO 控制loading下面的字
                simpleLoadingDialog.setLoadingText(progressDesc);
                simpleLoadingDialog.setCanceledOnTouchOutside(false);
                simpleLoadingDialog.show();
            } else {
                simpleLoadingDialog.show();
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
        if (simpleLoadingDialog != null && simpleLoadingDialog.getDialog().isShowing()) {
            simpleLoadingDialog.dismiss();
            simpleLoadingDialog = null;
            disHandler.removeCallbacks(disThread);
            return true;
        } else {
            disHandler.removeCallbacks(disThread);
            return false;
        }
//        return true;
    }

}