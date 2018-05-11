package com.gls.speed.sdk.resp;

/**
 * 加速状态查询
 */
public class GslStateQueryResp extends BaseResp {
    private int statusCode; //加速状态 0 未加速 1 加速中

    public int getState() {
        return statusCode;
    }

    public void setState(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "GslStateQueryResp{" +
                super.toString()+
                "statusCode='" + statusCode + '\'' +
                '}';
    }
}
