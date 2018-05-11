package com.gls.speed.sdk.model;

/**
 * Created by Administrator on 2018/5/4.
 */

/**
 * 宽带加速状态查询
 * /stateQuerySvc
 */
public class StateQuerySvc {
    private String className;//对应服务方
    private String IP;
    private String partner_code; //渠道编码
    private String timestamp;//时间戳(单位 ms)
    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getIp() {
        return IP;
    }

    public void setIp(String ip) {
        this.IP = ip;
    }

    public String getPartner_code() {
        return partner_code;
    }

    public void setPartner_code(String partner_code) {
        this.partner_code = partner_code;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "StateQuerySvc{" +
                "className='" + className + '\'' +
                ", ip='" + IP + '\'' +
                ", partner_code='" + partner_code + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
