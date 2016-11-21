package com.qrtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.BaseViewfinderView;

/**
 * Created by android-dev on 21/11/16.
 */

public class HtViewfinderView extends BaseViewfinderView {

    private ImageView imageView;
    private ImageView border;
    private Animation anim;

    public HtViewfinderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        imageView = new ImageView(context);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        addView(imageView, params);

        border = new ImageView(context);
        border.setImageResource(R.drawable.scan_box);
        params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        addView(border, params);
        imageView.setImageResource(R.drawable.qrcode_scan_square);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        anim = AnimationUtils.loadAnimation(getContext(), R.anim.qrcode_scan_anim);
        imageView.startAnimation(anim);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (anim != null)
            anim.cancel();
    }

    @Override
    public void drawViewfinder() {

    }

    @Override
    public void drawResultBitmap(Bitmap barcode) {

    }

    @Override
    public void addPossibleResultPoint(ResultPoint point) {

    }
}
