package com.google.zxing.client.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.camera.CameraManager;

/**
 * Created by android-dev on 21/11/16.
 */

public abstract class BaseViewfinderView extends FrameLayout {

    protected CameraManager cameraManager;

    public BaseViewfinderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(true);
    }

    public void setCameraManager(CameraManager cameraManager) {
        this.cameraManager = cameraManager;
    }

    public abstract void drawViewfinder();

    public abstract void drawResultBitmap(Bitmap barcode);

    public abstract void addPossibleResultPoint(ResultPoint point);
}
