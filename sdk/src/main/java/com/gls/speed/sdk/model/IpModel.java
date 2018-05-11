package com.gls.speed.sdk.model;

import com.gls.speed.sdk.base.BaseRespServer;

/**
 * Created by Administrator on 2018/5/4.
 */

public class IpModel extends BaseRespServer{

    private String ip;
    private String port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "IpModel{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
