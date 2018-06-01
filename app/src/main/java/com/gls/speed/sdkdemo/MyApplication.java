package com.gls.speed.sdkdemo;

import android.app.Application;

import com.gls.speed.sdk.GslAccelerate;

/**
 * Created by Administrator on 2018/5/15.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GslAccelerate.getInstance().glsAccelerateInit(this, "YUNVA", "18902478051", "fybsignyunva1234",true);
    }
}
