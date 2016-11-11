package com.example.shining.makejaraar.widget.loading.MaterialProgress;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.shining.makejaraar.R;


public class MaterialProgressBindDialog extends ProgressDialog {

    private ProgressWheel progressWheel;

    public MaterialProgressBindDialog(Context context) {
        super(context, R.style.materialprogress_dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_material_bind_progress);
//        this.setCanceledOnTouchOutside(false);
        setCancelable(false);
        progressWheel = (ProgressWheel) findViewById(R.id.progress_wheel);
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

}
