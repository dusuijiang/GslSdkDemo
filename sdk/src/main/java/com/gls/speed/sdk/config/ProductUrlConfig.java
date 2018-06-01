package com.gls.speed.sdk.config;

/**
 * Created by dengjun on 2017/10/16.
 */

public class ProductUrlConfig implements UrlConfig {
    private static final String PRODUCT_HTTP_SERVER = "https://gslserver.aiwaya.cn"; //正式地址
    // private static final String PRODUCT_HTTP_SERVER =  "http://106.75.25.25:8877";   //测试地址
    private static final String PRODUCT_GLS_HTTP_SERVER = "http://kdjs.fangyb.com:8088";  //正式地址
    // private static final String PRODUCT_GLS_HTTP_SERVER = "http://59.36.169.39:8089";  //测试地址
    private static final String PRODUCT_IP_HTTP_SERVER = "http://ip.taobao.com/service/getIpInfo.php?ip=myip&qq-pf-to=pcqq.c2c";
    public static final String SDKVERSION = "1.0.0";

    @Override
    public String getHttpUrl() {
        return PRODUCT_HTTP_SERVER;
    }

    @Override
    public String getGlsHttpUrl() {
        return PRODUCT_GLS_HTTP_SERVER;
    }

    @Override
    public String getIpUrl() {
        return PRODUCT_IP_HTTP_SERVER;
    }


}
