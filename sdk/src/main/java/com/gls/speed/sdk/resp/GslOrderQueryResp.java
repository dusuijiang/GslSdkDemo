package com.gls.speed.sdk.resp;

/**
 * 订单查询
 */
public class GslOrderQueryResp extends BaseResp {

    private long useTime; //总时长
    private long haveTime; //剩余时长
    private long usedTime; //已用时长
    private String endTime; //有效截止日期

    public long getUseTime() {
        return useTime;
    }

    public void setUseTime(long useTime) {
        this.useTime = useTime;
    }

    public long getHaveTime() {
        return haveTime;
    }

    public void setHaveTime(long haveTime) {
        this.haveTime = haveTime;
    }

    public long getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(int usedTime) {
        this.usedTime = usedTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "GslOrderQueryResp{" +
                super.toString()+
                "useTime=" + useTime +
                "haveTime=" + haveTime +
                ", usedTime=" + usedTime +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
