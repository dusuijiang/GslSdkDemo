package com.gls.speed.sdk.base;


public class BaseRespServer {
    private Long result = Result.RESULT_OK;
    private String msg=Result.getMsg(Result.RESULT_OK);

    public BaseRespServer() {
    }

    public BaseRespServer(Long result) {
        this.result = result;
        this.msg = Result.getMsg(result);
    }


    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseRespServer{");
        sb.append("result=").append(result);
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
