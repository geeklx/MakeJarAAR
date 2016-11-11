package com.example.shining.makejaraar.utils.textutils;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shining.makejaraar.R;


/**
 * --------------------------------------------
 * Create By :  Lvfq
 * Date ： 2016/11/10 0010 下午 4:01
 * -------------------------------------------
 * 带有 * 的必填 Label
 **/
public class MustTextView extends LinearLayout {

    public static final int DEFAULT_SIZE = 14;
    public static final int DEFAULT_PADDING = 3;
    public static final int SY_DEFAULT_COLOR = 0x7A7AFF;
    public static final int CONTENT_DEFAULT_COLOR = 0x444444;

    private int tv_size = DEFAULT_SIZE;
    private int tv_color = CONTENT_DEFAULT_COLOR;
    private int symbol_color = SY_DEFAULT_COLOR;
    private int symbol_size = DEFAULT_SIZE;
    private String content;
    private int drawPadding = DEFAULT_PADDING;

    public MustTextView(Context context) {
        super(context);
    }

    public MustTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MustTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MustTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }


    public void init(Context context, AttributeSet attrs){
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        tv_size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, tv_size, dm);
        symbol_size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, symbol_size, dm);
        drawPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, drawPadding, dm);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MustTextView);

        tv_size = ta.getDimensionPixelSize(R.styleable.MustTextView_tv_size, tv_size);
        tv_color = ta.getColor(R.styleable.MustTextView_tv_color, tv_color);
        symbol_size = ta.getDimensionPixelSize(R.styleable.MustTextView_symbol_size, symbol_size);
        symbol_color = ta.getColor(R.styleable.MustTextView_symbol_color, symbol_color);
        drawPadding = ta.getDimensionPixelSize(R.styleable.MustTextView_drawPadding, drawPadding);
        content = ta.getString(R.styleable.MustTextView_tv_content);

        ta.recycle();

        TextView sy_tv = new TextView(context);
        sy_tv.setText("*");
        sy_tv.setTextColor(getResources().getColor(R.color.colorAccent));
        sy_tv.setTextSize(symbol_size);
        addView(sy_tv);

        TextView content_tv = new TextView(context);
        content_tv.setText(content);
        content_tv.setTextColor(tv_color);
        content_tv.setTextSize(tv_size);
        addView(content_tv);
    }

    public void setSySize(int size) {
        TextView textView = (TextView) getChildAt(0);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public void setText(CharSequence text) {
        TextView textView = (TextView) getChildAt(1);
        textView.setText(text);
    }

    public void setTextColor(int color) {
        TextView textView = (TextView) getChildAt(1);
        textView.setTextColor(color);
    }

}
