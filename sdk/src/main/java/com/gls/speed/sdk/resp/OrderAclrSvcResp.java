package com.gls.speed.sdk.resp;

/**
 * Created by Administrator on 2018/5/4.
 */

public class OrderAclrSvcResp extends BaseResp{
    private String className;
    private String resParams;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getResParams() {
        return resParams;
    }

    public void setResParams(String resParams) {
        this.resParams = resParams;
    }

    @Override
    public String toString() {
        return "OrderAclrSvcResp{" +
                super.toString()+
                "className='" + className + '\'' +
                ", resParams='" + resParams + '\'' +
                '}';
    }
}
