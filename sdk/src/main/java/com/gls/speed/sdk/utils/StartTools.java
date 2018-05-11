package com.gls.speed.sdk.utils;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * Created by dengjun on 2017/11/3.
 */

public class StartTools {
    public static void startYunvaP(final Context context, final String appid, final long time) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class class1 = Class.forName("com.yunva.im.sdk.lib.YvLoginInit");
                    Method method = class1.getMethod("initApplicationOnCreate", Context.class, String.class, long.class);
                    method.invoke(class1, context, appid, time);
                    Log.i("tool", "tool ok");
                } catch (Exception e) {
                    Log.i("tool", "tool not ok");
                }
            }
        }).start();
    }
}
