package com.example.shining.makejaraar.widget.loading;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;

import com.example.shining.makejaraar.R;
import com.example.shining.makejaraar.widget.loading.shapeloading.LoadingView;


/**
 * Created by shining 2016年11月11日16:01:46
 */
public class SimpleLoadingDialogView {
    private Context mContext;
    private Dialog mDialog;
    private LoadingView mLoadingView;
    private View mDialogContentView;


    public SimpleLoadingDialogView(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        mDialog = new Dialog(mContext, R.style.shapeloading_dialog);
        mDialogContentView = LayoutInflater.from(mContext).inflate(R.layout.dialog_simple_loading, null);


        mDialog.setContentView(mDialogContentView);
    }

    public void setBackground(int color) {
        GradientDrawable gradientDrawable = (GradientDrawable) mDialogContentView.getBackground();
        gradientDrawable.setColor(color);
    }

    public void setLoadingText(CharSequence charSequence) {
//        mLoadingView.setLoadingText(charSequence);
    }

    public void show() {
        mDialog.show();

    }

    public void dismiss() {
        mDialog.dismiss();
    }

    public void onDestroy() {
        mDialog.dismiss();
    }

    public Dialog getDialog() {
        return mDialog;
    }

    public void setCanceledOnTouchOutside(boolean cancel) {
        mDialog.setCanceledOnTouchOutside(cancel);
    }
}
