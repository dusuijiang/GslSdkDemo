package com.gls.speed.sdk.model;


import com.gls.speed.sdk.base.BaseReq;

/**
 * Created by GLR on 2017/7/14 15:02.
 * 应用初始化
 * /app/init
 * 返回是BaseResp
 */
public class InitReq extends BaseReq {
    private String partnerCode;
    private String userAccount;
    private DevInfo devInfo;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InitReq{");
        sb.append("partnerCode='").append(partnerCode).append('\'');
        sb.append(", userAccount='").append(userAccount).append('\'');
        sb.append(", devInfo=").append(devInfo);
        sb.append('}');
        return sb.toString();
    }
}
