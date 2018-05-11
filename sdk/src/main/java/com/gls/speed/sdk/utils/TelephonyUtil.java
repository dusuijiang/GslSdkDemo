package com.gls.speed.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by wy on 14-3-11.
 */
public class TelephonyUtil {
    private static final String TAG = "TelephonyUtil";
    public static final String CPU_TYPE_DEFAULT = "0";
    public static final String CPU_TYPE_ARM_V5 = "1";
    public static final String CPU_TYPE_ARM_V6 = "2";
    public static final String CPU_TYPE_ARM_V7 = "3";

    /**
     * 获取操作系统类型
     *
     * @return
     */
    public static String getOsType() {
        return "1"; // 1为android
    }

    /**
     * 获取应用版本号
     *
     * @param context
     * @return
     */
    public static String getAppVersion(Context context) {
        try {
            PackageManager pm = context.getPackageManager();

            if (pm != null) {
                PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);

                if (pi != null) {
                    return pi.versionName;
                }
            }
        } catch (Exception e) {
            MLog.e("getAppVersion failure.exception:" + e);
            return null;
        }

        return "";
    }

    /**
     * 获取应用版本号
     *
     * @param context
     * @return
     */
    public static int getAppVersionCode(Context context) {
        try {
            PackageManager pm = context.getPackageManager();

            if (pm != null) {
                PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);

                if (pi != null) {
                    return pi.versionCode;
                }
            }
        } catch (Exception e) {
            MLog.e("getAppVersion failure.exception:" + e);
            return 0;
        }

        return 0;
    }

    /**
     * 获取应用环境
     *
     * @param context
     * @return
     */
//    public static String getEnvironment(Context context) {
//        try {
//            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
//            return applicationInfo.metaData.getString("environment");
//        } catch (Exception e) {
//            MLog.e(TAG, "getChannelId failure.exception:" + ExceptionUtil.getStackTrace(e));
//            return null;
//        }
//    }

    /**
     * 获取渠道编号
     *
     * @return
     */
    public static String getChannelId(Context context) {
//        return null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(),
                            PackageManager.GET_META_DATA);
            if (applicationInfo.metaData != null && applicationInfo.metaData.getString("channel_id") != null) {
                return applicationInfo.metaData.getString("channel_id");
            } else {
                return "";
            }
        } catch (Exception e) {
            MLog.e("getChannelId failure.exception:" + e);
            return "";
        }
    }

    /**
     * 获取CPU类型
     *
     * @return String CPU类型：{@link #CPU_TYPE_DEFAULT}, {@link #CPU_TYPE_ARM_V5},
     * {@link #CPU_TYPE_ARM_V6}, {@link #CPU_TYPE_ARM_V7},
     */
    public static String getCpuType() {
        String cpuName = getCpuName();
        if (null == cpuName) {
            return CPU_TYPE_DEFAULT;
        } else if (cpuName.contains("ARMv7")) {
            return CPU_TYPE_ARM_V7;
        } else if (cpuName.contains("ARMv6")) {
            return CPU_TYPE_ARM_V6;
        } else if (cpuName.contains("ARMv5")) {
            return CPU_TYPE_ARM_V5;
        }

        return CPU_TYPE_DEFAULT;
    }

    public static String getCpuName() {
        FileReader fr = null;
        BufferedReader br = null;
        String[] array = null;
        try {
            fr = new FileReader("/proc/cpuinfo");
            br = new BufferedReader(fr);
            String text = br.readLine();
            array = text.split(":\\s+", 2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (array != null && array.length >= 2) {
            return array[1];
        }
        return "";
    }

    /**
     * 获取分辨率
     *
     * @param context
     * @return
     */
    public static String getDisplay(Context context) {
        return null;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getTelephonyModel() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            MLog.e(TAG, "getTelephonyModel failure.exception:" + e);
            return "";
        }

//        return "";
    }

    /**
     * 获取手机版本
     *
     * @return
     */
    public static String getTelephonyVersion() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Exception e) {
            MLog.e(TAG, "getTelephonyVersion failure.exception:" + e);
            return "";
        }

//        return "";
    }

    /**
     * 获取手机厂商名称
     *
     * @return
     */
    public static String getManufacturer() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception e) {
            MLog.e(TAG, "getManufacturer failure.exception:" + e);
            return "";
        }

//        return "";
    }

    /**
     * 获取系统版本编号
     *
     * @return
     */
    public static int getSystemVersionCode() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e) {
            MLog.e(TAG, "getSystemVersionCode failure.exception:" + e);
            return -1;
        }

//        return 0;
    }

    /**
     * 获取系统版本名称
     *
     * @return
     */
    public static String getSystemVersionName() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Exception e) {
            MLog.e(TAG, "getSystemVersionName failure.exception:" + e);
            return "";
        }

//        return "";
    }

    /**
     * 获取MAC地址
     *
     * @param context
     * @return
     */
    public static String getMac(Context context) {
        // 在wifi未开启状态下，仍然可以获取MAC地址，但是IP地址必须在已连接状态下否则为0
        try {
            WifiManager wifiMgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());
            if (null != info) {
                return info.getMacAddress();
            }
        } catch (Exception e) {
            // MLog.e(TAG, "getMac failure.exception:" + ExceptionUtil.getStackTrace(e));
            return "";
        }

        return "";
    }

    /**
     * 获取IMSI号
     *
     * @param context
     * @return
     */
    @SuppressLint("MissingPermission")
    public static String getImsi(Context context) {
        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (tm != null && tm.getSubscriberId() != null) {
                return tm.getSubscriberId();
            }
        } catch (Exception e) {
            //MLog.w(TAG, "getImsi failure.exception:" + ExceptionUtil.getStackTrace(e));
            return "";
        }

        return "";
    }

    /**
     * 获取IMEI号
     *
     * @param context
     * @return
     */
    public static String getImei(Context context) {
        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (tm != null && tm.getDeviceId() != null) {
                return tm.getDeviceId();
            } else {
                return "";
            }
        } catch (Exception e) {
            //MLog.w(TAG, "getImei failure.exception:" + ExceptionUtil.getStackTrace(e));
            return "";
        }
    }

    public static String getIccid(Context context) {
        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (tm.getSimSerialNumber() == null) {
                return "";
            }
            return tm.getSimSerialNumber(); // 取出ICCID
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    /**
     * 获取电话号码
     */
    public static String getNativePhoneNumber(Context context) {
        String NativePhoneNumber = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        NativePhoneNumber = telephonyManager.getLine1Number();
        return NativePhoneNumber;
    }

    /**
     * 获取UUID号
     *
     * @param context
     * @return
     */
    protected static final String PREFS_FILE = "device_id.xml";
    protected static final String PREFS_DEVICE_ID = "device_id";
    protected static UUID uuid;

    public static int getWeith(Context context) {

        //在service中也能得到高和宽
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return mWindowManager.getDefaultDisplay().getWidth();
        //height = mWindowManager.getDefaultDisplay().getHeight();
    }

    public static int getHeight(Context context) {

        //在service中也能得到高和宽
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return mWindowManager.getDefaultDisplay().getHeight();
    }

    /**
     * 获取手机内部可用空间大小
     *
     * @return 大小，字节为单位
     */
    public static long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        //获取可用区块数量
        long availableBlocks = stat.getAvailableBlocks();
        return availableBlocks * blockSize;
    }

    /**
     * 获取手机内部空间总大小
     *
     * @return 大小，字节为单位
     */
    public static long getTotalInternalMemorySize() {
        //获取内部存储根目录
        File path = Environment.getDataDirectory();
        //系统的空间描述类
        StatFs stat = new StatFs(path.getPath());
        //每个区块占字节数
        long blockSize = stat.getBlockSize();
        //区块总数
        long totalBlocks = stat.getBlockCount();
        return totalBlocks * blockSize;
    }

    //获取mac
    public static String getMac() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:",b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "02:00:00:00:00:00";
    }

    public static String getLocalMacAddress() {
        String mac = null;
        try {
            String path = "sys/class/net/eth0/address";
            FileInputStream fis_name = new FileInputStream(path);
            byte[] buffer_name = new byte[8192];
            int byteCount_name = fis_name.read(buffer_name);
            if (byteCount_name > 0) {
                mac = new String(buffer_name, 0, byteCount_name, "utf-8");
            }


            if (mac == null) {
                fis_name.close();
                return "";
            }
            fis_name.close();
        } catch (Exception io) {
            String path = "sys/class/net/wlan0/address";
            FileInputStream fis_name;
            try {
                fis_name = new FileInputStream(path);
                byte[] buffer_name = new byte[8192];
                int byteCount_name = fis_name.read(buffer_name);
                if (byteCount_name > 0) {
                    mac = new String(buffer_name, 0, byteCount_name, "utf-8");
                }
                fis_name.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        if (mac == null) {
            return "";
        } else {
            return mac.trim();
        }

    }
}
