package com.gls.speed.sdk.model;


/**
 * 订购加速无回调服务
 * /synOrderAclrSvc
  */
public class SynOrderAclrSvc {
    private String product_code; //子产品编码
    private String user_account;//用户账号
    private String IP;
    private String partner_order_id;//流水号
    private String partner_code; //渠道编码
    private String timestamp;//时间戳(单位 ms)
    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getIp() {
        return IP;
    }

    public void setIp(String ip) {
        this.IP = ip;
    }

    public String getPartner_order_id() {
        return partner_order_id;
    }

    public void setPartner_order_id(String partner_order_id) {
        this.partner_order_id = partner_order_id;
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
        return "SynOrderAclrSvc{" +
                "product_code='" + product_code + '\'' +
                ", user_account='" + user_account + '\'' +
                ", ip='" + IP + '\'' +
                ", partner_order_id='" + partner_order_id + '\'' +
                ", partner_code='" + partner_code + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
