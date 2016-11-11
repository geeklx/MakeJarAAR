package com.example.shining.makejaraar.widget.loading.MaterialProgress;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.shining.makejaraar.R;


public class MaterialProgressDialog extends ProgressDialog {

    private ProgressWheel progressWheel;
    private TextView tv_content;
    private CharSequence ishave_tv_content = "";
//    private RelativeLayout mMenuView;

    public MaterialProgressDialog(Context context) {
        super(context, R.style.materialprogress_dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_material_progress);
//        LayoutInflater inflater = (LayoutInflater) mContext
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        mMenuView = (RelativeLayout) inflater.inflate(R.layout.dialog_material_progress, null);
        progressWheel = (ProgressWheel) findViewById(R.id.progress_wheel);
        tv_content = (TextView) findViewById(R.id.tv_content_progress);
        if (!TextUtils.isEmpty(ishave_tv_content)) {
            tv_content.setText(ishave_tv_content);
        }
//        setCanceledOnTouchOutside(true);
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                resetProgressWhell();
            }
        });
    }

    protected void resetProgressWhell() {
        progressWheel.resetCount();
    }

    public void setLoadingText(CharSequence charSequence) {
//        tv_content.setText(charSequence);
        ishave_tv_content = charSequence;
        if (tv_content != null) {
            tv_content.setText(charSequence);
        }
    }

    public void setCanceledOnTouchOutside(boolean cancel) {
//        setCanceledOnTouchOutside(cancel);
        setCancelable(cancel);
    }
}
