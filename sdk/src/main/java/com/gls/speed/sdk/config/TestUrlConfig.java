package com.gls.speed.sdk.config;

/**
 * Created by dengjun on 2017/10/16.
 */

public class TestUrlConfig implements UrlConfig {
    private static final String TEST_HTTP_SERVER = "http://106.75.103.152:8091";
    @Override
    public String getHttpUrl() {
        return TEST_HTTP_SERVER;
    }

    @Override
    public String getGlsHttpUrl() {
        return null;
    }

    @Override
    public String getIpUrl() {
        return null;
    }

}
