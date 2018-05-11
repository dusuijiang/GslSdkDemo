package com.gls.speed.sdk.resp;

/**
 * Created by Administrator on 2018/5/4.
 */

public class BaseResp {
    private Long resCode ; //返回码
    private String resMsg; //返回码描述

    public BaseResp() {

    }

    public Long getResCode() {
        return resCode;
    }

    public void setResCode(Long resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    @Override
    public String toString() {
        return
                "resCode=" + resCode +
                ", resMsg='" + resMsg +"," + '\''
               ;
    }
}
