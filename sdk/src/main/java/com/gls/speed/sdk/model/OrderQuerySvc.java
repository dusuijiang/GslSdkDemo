package com.gls.speed.sdk.model;

/**
 * Created by Administrator on 2018/5/4.
 */

/**
 * 订单查询服务
 * /orderQuerySvc
 */
public class OrderQuerySvc {
    private String className; //对应服务方
    private String order_id; //订单编码
    private String partner_code; //渠道编码
    private String timestamp;//时间戳(单位 ms)
    private String sign;//加密串

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

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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
        return "OrderQuerySvc{" +
                "className='" + className + '\'' +
                ", order_id='" + order_id + '\'' +
                ", partner_code='" + partner_code + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
