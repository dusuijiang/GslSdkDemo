package com.gls.speed.sdk.utils;

import android.content.Context;

/**
 * Created by dengjun on 2017/10/23.
 */

public class ProcessUtils {
    public static  String getPackageName(Context context) {
        try {
            String pkName = context.getPackageName();
            return pkName;
        } catch (Exception e) {
            return "";
        }
    }
}
