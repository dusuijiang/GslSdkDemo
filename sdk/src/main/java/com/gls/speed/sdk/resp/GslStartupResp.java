package com.gls.speed.sdk.resp;

import com.third.google.gson.annotations.SerializedName;

/**
 * 开启加速
 */
public class GslStartupResp extends BaseResp {

    @SerializedName("resCDRID")
    private String cdrid; //加速流水号

    public String getCdrid() {
        return cdrid;
    }

    public void setCdrid(String cdrid) {
        this.cdrid = cdrid;
    }

    @Override
    public String toString() {
        return "GslStartupResp{" +
                super.toString() +
                "cdrid='" + cdrid + '\'' +
                '}';
    }
}
