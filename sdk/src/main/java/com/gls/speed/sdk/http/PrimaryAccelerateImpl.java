package com.gls.speed.sdk.http;

import com.gls.speed.sdk.base.BaseRespServer;
import com.gls.speed.sdk.impl.RequestCallback;
import com.gls.speed.sdk.impl.IGslAccelerate;
import com.gls.speed.sdk.model.InitReq;
import com.gls.speed.sdk.config.UrlBuilder;
import com.gls.speed.sdk.model.IpModel;
import com.gls.speed.sdk.model.OrderAclrSvc;
import com.gls.speed.sdk.model.OrderQuerySvc;
import com.gls.speed.sdk.model.QualCkeckSvc;
import com.gls.speed.sdk.model.StartupAclrSvc;
import com.gls.speed.sdk.model.StateQuerySvc;
import com.gls.speed.sdk.model.StopAclrSvc;
import com.gls.speed.sdk.model.SynOrderAclrSvc;
import com.gls.speed.sdk.resp.BaseResp;
import com.gls.speed.sdk.resp.GslCheckResp;
import com.gls.speed.sdk.resp.GslOrderQueryResp;
import com.gls.speed.sdk.resp.GslOrderResp;
import com.gls.speed.sdk.resp.GslStartupResp;
import com.gls.speed.sdk.resp.GslStateQueryResp;
import com.gls.speed.sdk.resp.GslStopResp;
import com.gls.speed.sdk.resp.OrderAclrSvcResp;
import com.gls.speed.sdk.storage.StorageManage;
import com.gls.speed.sdk.utils.AESUtils;
import com.gls.speed.sdk.utils.Base64Util;
import com.gls.speed.sdk.utils.DataJsonTranslation;
import com.gls.speed.sdk.utils.EncryptUtil;
import com.gls.speed.sdk.utils.IP;
import com.gls.speed.sdk.utils.MLog;
import com.gls.speed.sdk.utils.SortUtil;

import java.util.Map;
import java.util.Random;

public class PrimaryAccelerateImpl implements IGslAccelerate {

    private PrimaryHttpClient mPrimaryHttpClient = new PrimaryHttpClient();

    public PrimaryAccelerateImpl() {
    }


    private String aesEncrypt(Object object) {
        try {
            String encryptString = AESUtils.encode(Base64Util.encryptString(DataJsonTranslation.objectToJson(object)));
            return encryptString;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String reqBody(Object object) {
        SortUtil sortUtil = new SortUtil();
        Map map = DataJsonTranslation.objectToMap(object);
        map.remove("sign");
        String needString1 = sortUtil.formatUrlMap(map, false, false);
        return EncryptUtil.ecodes(needString1, StorageManage.getInstance().getKey());
    }

    @Override
    public void uploadDeviceInfo(InitReq initReq, final RequestCallback callback) {
        try {
            String returnString = mPrimaryHttpClient.requestSync(UrlBuilder.getInstance().getInitReqUrl(), DataJsonTranslation.objectToJson(initReq));
            if (callback != null) {
                callback.onResult(DataJsonTranslation.jsonToObject(returnString, BaseRespServer.class));
            }
        } catch (Exception e) {
            MLog.e("uploadInfo error : " + e);
            if (callback != null) {
                callback.onError(e);
            }
        }
    }


    @Override
    public void qualificationsCheckService(QualCkeckSvc qualCkeckSvc, RequestCallback callback) {

        qualCkeckSvc.setSign(reqBody(qualCkeckSvc));
        String returnString;
        try {

            while (true) {
                returnString = mPrimaryHttpClient.requestSync(UrlBuilder.getInstance().getQualCkeckSvc(), DataJsonTranslation.objectToJson(qualCkeckSvc));
                MLog.d("returnString",returnString);
                BaseResp baseResp = (BaseResp) DataJsonTranslation.jsonToObject(returnString, BaseResp.class);
                if (baseResp.getResCode() == 10000L)
                    break;

                IP.setIp(new Random().nextInt(IP.arr.length));
                StorageManage.getInstance().setIP(IP.IP+":8799");
                qualCkeckSvc.setIp(StorageManage.getInstance().getIP());
                qualCkeckSvc.setSign(reqBody(qualCkeckSvc));
            }
            if (callback != null) {
                callback.onResult(DataJsonTranslation.jsonToObject(returnString, GslCheckResp.class));
            }
        } catch (Exception e) {
            MLog.e("uploadInfo error : " + e);
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    @Override
    public void orderAccelerateService(OrderAclrSvc orderAclrSvc, RequestCallback callback) {
        orderAclrSvc.setSign(reqBody(orderAclrSvc));
        try {
            String returnString = mPrimaryHttpClient.requestSync(UrlBuilder.getInstance().getOrderAclrSvc(), DataJsonTranslation.objectToJson(orderAclrSvc));
            if (callback != null) {
                BaseResp baseResp = (BaseResp) DataJsonTranslation.jsonToObject(returnString, BaseResp.class);
                if (baseResp.getResCode() == 10000L){
                    OrderAclrSvcResp  orderAclrSvcResp = (OrderAclrSvcResp) DataJsonTranslation.jsonToObject(returnString, BaseResp.class);
                    StorageManage.getInstance().setClassName(orderAclrSvcResp.getClassName());
                }
                callback.onResult(DataJsonTranslation.jsonToObject(returnString, OrderAclrSvcResp.class));
            }
        } catch (Exception e) {
            MLog.e("uploadInfo error : " + e);
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    @Override
    public void synOrderAccelerateServicec(SynOrderAclrSvc synOrderAclrSvc, RequestCallback callback) {
        synOrderAclrSvc.setSign(reqBody(synOrderAclrSvc));
        try {
            String returnString = mPrimaryHttpClient.requestSync(UrlBuilder.getInstance().getSynOrderAclrSvc(), DataJsonTranslation.objectToJson(synOrderAclrSvc));
            BaseResp baseResp = (BaseResp) DataJsonTranslation.jsonToObject(returnString, BaseResp.class);
            if (baseResp.getResCode() == 10000L){
                StorageManage.getInstance().setClassName( DataJsonTranslation.toMap(returnString).get("className"));
            }
            if (callback != null) {
                callback.onResult(DataJsonTranslation.jsonToObject(returnString, GslOrderResp.class));
            }
        } catch (Exception e) {
            MLog.e("uploadInfo error : " + e);
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    @Override
    public void orderQueryService(OrderQuerySvc orderQuerySvc, RequestCallback callback) {
        orderQuerySvc.setSign(reqBody(orderQuerySvc));
        try {
            String returnString = mPrimaryHttpClient.requestSync(UrlBuilder.getInstance().getOrderQuerySvc(), DataJsonTranslation.objectToJson(orderQuerySvc));
            if (callback != null) {
                callback.onResult(DataJsonTranslation.jsonToObject(returnString, GslOrderQueryResp.class));
            }
        } catch (Exception e) {
            MLog.e("uploadInfo error : " + e);
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    @Override
    public void startUpAccelerateService(StartupAclrSvc startupAclrSvc, RequestCallback callback) {
        startupAclrSvc.setSign(reqBody(startupAclrSvc));
        try {
            String returnString = mPrimaryHttpClient.requestSync(UrlBuilder.getInstance().getStartupAclrSvc(), DataJsonTranslation.objectToJson(startupAclrSvc));
            if (callback != null) {
                callback.onResult(DataJsonTranslation.jsonToObject(returnString, GslStartupResp.class));
            }
        } catch (Exception e) {
            MLog.e("uploadInfo error : " + e);
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    @Override
    public void stopAccelerateService(StopAclrSvc stopAclrSvc, RequestCallback callback) {
        stopAclrSvc.setSign(reqBody(stopAclrSvc));
        try {
            String returnString = mPrimaryHttpClient.requestSync(UrlBuilder.getInstance().getStopAclrSvc(), DataJsonTranslation.objectToJson(stopAclrSvc));
            if (callback != null) {
                callback.onResult(DataJsonTranslation.jsonToObject(returnString, GslStopResp.class));
            }
        } catch (Exception e) {
            MLog.e("uploadInfo error : " + e);
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    @Override
    public void stateQueryService(StateQuerySvc stateQuerySvc, RequestCallback callback) {
        stateQuerySvc.setSign(reqBody(stateQuerySvc));
        try {
            String returnString = mPrimaryHttpClient.requestSync(UrlBuilder.getInstance().getStateQuerySvc(), DataJsonTranslation.objectToJson(stateQuerySvc));
            if (callback != null) {
                callback.onResult(DataJsonTranslation.jsonToObject(returnString, GslStateQueryResp.class));
            }
        } catch (Exception e) {
            MLog.e("uploadInfo error : " + e);
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    @Override
    public void getIp() {
        try {
            String returnString = mPrimaryHttpClient.requestSync(UrlBuilder.getInstance().getIpUrl());
            IpModel ipModel = (IpModel) DataJsonTranslation.jsonToObject(returnString, IpModel.class);
            MLog.d("TAG","ipModel : " + ipModel.toString());
        } catch (Exception e) {
            MLog.e("uploadInfo error : " + e);
        }
    }

}
