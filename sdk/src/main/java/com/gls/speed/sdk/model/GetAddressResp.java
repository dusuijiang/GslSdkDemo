package com.gls.speed.sdk.model;

import com.gls.speed.sdk.base.BaseRespServer;

/**
 * Created by GLR
 * 返回ip和端口
 * 路径 /get/address
 */
public class GetAddressResp extends BaseRespServer {
    private String ip;
    private int port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetAddressResp{");
        sb.append("ip='").append(ip).append('\'');
        sb.append(", port=").append(port);
        sb.append('}');
        return sb.toString();
    }
}
