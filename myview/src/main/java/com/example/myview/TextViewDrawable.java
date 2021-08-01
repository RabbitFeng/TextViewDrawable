package com.example.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Author: Dong
 * Time: 2021/1/29
 * TextDrawable
 * TextView中设置Drawable图像并调整尺寸
 */
public class TextViewDrawable extends AppCompatTextView {
    public static final String TAG = "DrawableTextView";

    private Drawable drawableTop;
    private Drawable drawableBottom;
    private Drawable drawableStart;
    private Drawable drawableEnd;

    private int drawableWidth;
    private int drawableHeight;

    private int topWidth;
    private int topHeight;
    private int bottomWidth;
    private int bottomHeight;
    private int startWidth;
    private int startHeight;
    private int endWidth;
    private int endHeight;

    private int mWidth;
    private int mHeight;

    public TextViewDrawable(Context context) {
//        super(context);
        this(context, null);
    }

    public TextViewDrawable(Context context, AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
    }

    public TextViewDrawable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Drawable[] compoundDrawables = getCompoundDrawables();
        for (int i = 0; i < compoundDrawables.length; i++) {
            if (compoundDrawables[i] == null) {
                Log.d(TAG, "TextDrawable: compoundDrawable is null-" + i);
            }
        }

        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        drawableStart = compoundDrawablesRelative[0];
        drawableTop = compoundDrawablesRelative[1];
        drawableEnd = compoundDrawablesRelative[2];
        drawableBottom = compoundDrawablesRelative[3];

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextDrawable);

        drawableWidth = typedArray.getDimensionPixelSize(R.styleable.TextDrawable_drawable_width, 0);
        drawableHeight = typedArray.getDimensionPixelSize(R.styleable.TextDrawable_drawable_height, 0);

        topWidth = typedArray.getDimensionPixelSize(R.styleable.TextDrawable_top_width, drawableWidth);
        topHeight = typedArray.getDimensionPixelSize(R.styleable.TextDrawable_top_height, drawableHeight);
        bottomWidth = typedArray.getDimensionPixelSize(R.styleable.TextDrawable_bottom_width, drawableWidth);
        bottomHeight = typedArray.getDimensionPixelSize(R.styleable.TextDrawable_bottom_height, drawableHeight);
        startWidth = typedArray.getDimensionPixelSize(R.styleable.TextDrawable_start_width, drawableWidth);
        startHeight = typedArray.getDimensionPixelSize(R.styleable.TextDrawable_start_height, drawableHeight);
        endWidth = typedArray.getDimensionPixelSize(R.styleable.TextDrawable_end_width, drawableWidth);
        endHeight = typedArray.getDimensionPixelSize(R.styleable.TextDrawable_end_height, drawableHeight);

        Log.d(TAG, "TextDrawable: drawableWidth:" + drawableWidth + ",drawableHeight:" + drawableHeight);
        Log.d(TAG, "TextDrawable: endWid:" + endWidth + ",endHei:" + endHeight);
        typedArray.recycle();
        setDrawablesRelative();
    }

    private void setDrawablesRelative() {
        Log.d(TAG, "setDrawablesRelative: called");
        if (drawableTop != null) {
            drawableTop.setBounds(0, 0, topWidth, topHeight);
            Log.d(TAG, "setDrawablesRelative: drawableTop:" + 0 + "," +
                    "top:" + 0 + "," +
                    "right:" + topWidth + "," +
                    "bottom:" + topHeight);
        }
        if (drawableBottom != null) {
            drawableBottom.setBounds(0, 0, bottomWidth, bottomHeight);
            Log.d(TAG, "setDrawablesRelative: drawableBottom:" + 0 + "," +
                    "top:" + 0 + "," +
                    "right:" + bottomWidth + "," +
                    "bottom:" + bottomHeight);
        }
        if (drawableStart != null) {
            drawableStart.setBounds(0, 0, startWidth, startHeight);
            Log.d(TAG, "setDrawablesRelative: drawableStart:" + 0 + "," +
                    "top:" + 0 + "," +
                    "right:" + startWidth + "," +
                    "bottom:" + startHeight);
        }
        if (drawableEnd != null) {
            drawableEnd.setBounds(0, 0, endWidth, endHeight);
            Log.d(TAG, "setDrawablesRelative: drawableEnd:" + 0 + "," +
                    "top:" + 0 + "," +
                    "right:" + endWidth + "," +
                    "bottom:" + endHeight);
        }
        setCompoundDrawablesRelative(drawableStart, drawableTop, drawableEnd, drawableBottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure: called:getMeasuredWidth:" + getMeasuredWidth() + "," +
                "getMeasuredHeight:" + getMeasuredHeight());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
        Log.d(TAG, "onSizeChanged:" + mWidth + "*" + mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: called");
    }

    // Setters
    public void setDrawableTop(Drawable drawableTops) {
        this.drawableTop = drawableTop;
        setDrawablesRelative();
    }

    public void setDrawableBottom(Drawable drawableBottom) {
        this.drawableBottom = drawableBottom;
        setDrawablesRelative();
    }

    public void setDrawableStart(Drawable drawableStart) {
        this.drawableStart = drawableStart;
        setDrawablesRelative();
    }

    public void setDrawableEnd(Drawable drawableEnd) {
        this.drawableEnd = drawableEnd;
        setDrawablesRelative();
    }
}
