package com.gls.speed.sdk.resp;

import com.third.google.gson.annotations.SerializedName;

/**
 *  订购加速
 */
public class GslOrderResp extends BaseResp {
    @SerializedName("order_id")
    private String orderId; //订单流水号
    @SerializedName("end_time")
    private String endTime; //订单到期时间

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "GslOrderResp{" +
                super.toString()+
                ", orderId='" + orderId + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
