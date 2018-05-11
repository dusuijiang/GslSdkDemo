package com.gls.speed.sdk.impl;

import com.gls.speed.sdk.model.InitReq;
import com.gls.speed.sdk.model.OrderAclrSvc;
import com.gls.speed.sdk.model.OrderQuerySvc;
import com.gls.speed.sdk.model.QualCkeckSvc;
import com.gls.speed.sdk.model.StartupAclrSvc;
import com.gls.speed.sdk.model.StateQuerySvc;
import com.gls.speed.sdk.model.StopAclrSvc;
import com.gls.speed.sdk.model.SynOrderAclrSvc;

/**
 * Created by Administrator on 2018/5/4.
 */

public interface IGslAccelerate {

    void uploadDeviceInfo(InitReq initReq, RequestCallback callback);

    //资格审查服务
    void qualificationsCheckService(QualCkeckSvc qualCkeckSvc, RequestCallback callback);

    //订购加速服务
    void orderAccelerateService(OrderAclrSvc orderAclrSvc, RequestCallback callback);

    //订购加速无回调服务
    void synOrderAccelerateServicec(SynOrderAclrSvc synOrderAclrSvc, RequestCallback callback);

    //订单查询服务
    void orderQueryService(OrderQuerySvc orderQuerySvc, RequestCallback callback);

    //启动加速服务
    void startUpAccelerateService(StartupAclrSvc startupAclrSvc, RequestCallback callback);

    //停止加速服务
    void stopAccelerateService(StopAclrSvc stopAclrSvc, RequestCallback callback);

    //宽带加速状态查询
    void stateQueryService(StateQuerySvc stateQuerySvc, RequestCallback callback);

    void getIp();
}
