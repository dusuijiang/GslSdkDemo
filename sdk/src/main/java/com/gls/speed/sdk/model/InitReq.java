package com.gls.speed.sdk.model;


import com.gls.speed.sdk.base.BaseReq;

/**
 * Created by GLR on 2017/7/14 15:02.
 * 应用初始化
 * 路径 /app/init
 * 返回是BaseResp
 */
public class InitReq extends BaseReq {
    private String partnerCode;
    private String userAccount;
    private DevInfo devInfo;
    private String appid;//appid
    private String sdkId;

    public String getSdkId() {
        return sdkId;
    }

    public void setSdkId(String sdkId) {
        this.sdkId = sdkId;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public DevInfo getDevInfo() {
        return devInfo;
    }

    public void setDevInfo(DevInfo devInfo) {
        this.devInfo = devInfo;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InitReq{");
        sb.append("partnerCode='").append(partnerCode).append('\'');
        sb.append(", userAccount='").append(userAccount).append('\'');
        sb.append(", devInfo=").append(devInfo);
        sb.append(", appid='").append(appid).append('\'');
        sb.append(", sdkId='").append(sdkId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
