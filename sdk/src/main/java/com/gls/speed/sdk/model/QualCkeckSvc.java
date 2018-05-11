package com.gls.speed.sdk.model;

/**
 * Created by Administrator on 2018/5/4.
 */

/**
 * 资格审查服务
 * /qualCheckSvc
 */

public class QualCkeckSvc {
    private String IP;
    private String partner_code; //渠道编码(平台提供)
    private String timestamp; //时间戳(单位 ms)
    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getIp() {
        return IP;
    }

    public void setIp(String ip) {
        this.IP = ip;
    }

    public String getParter_code() {
        return partner_code;
    }

    public void setParter_code(String parter_code) {
        this.partner_code = parter_code;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "QualCkeckSvc{" +
                "ip='" + IP + '\'' +
                ", partner_code='" + partner_code + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}

