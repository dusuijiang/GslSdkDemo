package com.gls.speed.sdk.utils;

import java.util.Random;

/**
 * Created by Administrator on 2018/5/8.
 */

public class IP {
    public static String[] arr = {"114.89.125.37",
            "36.40.121.15",
            "27.186.191.113",
            "36.44.141.116",
            "42.122.53.123",
            "110.188.58.244",
            "27.154.142.250",
            "125.78.206.34",
            "111.79.223.57",
            "117.23.198.155",
            "113.128.134.194",
            "111.121.245.156",
            "175.44.134.3",
            "175.2.229.198",
            "111.173.151.100",
            "123.246.109.159",
            "1.182.230.160",
            "182.108.100.77",
            "120.41.133.155",
            "171.9.45.152",
            "36.249.44.78",
            "182.134.16.94",
            "182.84.214.107",
            "182.84.214.107",
            "218.0.92.97",
            "182.201.188.7",
            "223.149.239.37",
            "111.113.80.48",
            "111.182.52.1",
            "110.186.87.88",
            "60.183.74.227",
            "124.114.206.135",
            "183.142.24.41",
            "122.7.60.131",
            "14.105.6.48",
            "106.86.107.61",
            "120.34.172.253",
            "1.83.32.64",
            "125.75.236.178",
            "171.94.36.202",
            "125.105.163.204",
            "113.140.177.48",
            "125.124.24.22",
            "223.152.170.244",
            "27.186.9.163",
            "171.217.65.235",
            "117.30.95.53",
            "113.223.52.61",
            "123.55.46.48",
            "117.33.23.227",
    };

    public static void setIp(int i) {
        IP = arr[i % arr.length];
    }

    private static String getIP() {
        int i = new Random().nextInt(arr.length);
        IP = arr[i];
        return IP;
    }

    public static String IP = getIP();
}