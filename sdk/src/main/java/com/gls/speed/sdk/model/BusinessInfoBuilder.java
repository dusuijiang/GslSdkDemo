package com.gls.speed.sdk.model;

import android.content.Context;

import com.gls.speed.sdk.storage.StorageManage;
import com.gls.speed.sdk.utils.DensityUtil;
import com.gls.speed.sdk.utils.NetworkUtil;
import com.gls.speed.sdk.utils.TelephonyUtil;
import com.gls.speed.sdk.utils.UUIDGenerator;

/**
 * Created by dengjun on 2017/10/16.
 */

public class BusinessInfoBuilder {
    public static DevInfo builderDevInfoReq(Context context){
        DevInfo devInfo = new DevInfo();
        devInfo.setSSID(NetworkUtil.getWifiSsid(context));
        devInfo.setSignalStrength(NetworkUtil.getRssi(context)+"dBm");
        devInfo.setUuid(UUIDGenerator.getUUID(context));
        devInfo.setImei(TelephonyUtil.getImei(context));
        devInfo.setImsi(TelephonyUtil.getImsi(context));
        devInfo.setOsType(1);
        devInfo.setAppVersion(TelephonyUtil.getAppVersion(context));
        devInfo.setModel(TelephonyUtil.getTelephonyModel());
        devInfo.setBrand(TelephonyUtil.getManufacturer());
        devInfo.setNetworkType(NetworkUtil.getNetworkType(context));
        devInfo.setCpu(TelephonyUtil.getCpuType());
        devInfo.setOsVersion(TelephonyUtil.getTelephonyVersion());
        devInfo.setMac(TelephonyUtil.getLocalMacAddress());
        devInfo.setAndroidId(TelephonyUtil.getIccid(context));
        devInfo.setIdfa("");
        devInfo.setRam("");
        devInfo.setStoreUsed(TelephonyUtil.getTotalInternalMemorySize() - TelephonyUtil.getAvailableInternalMemorySize() + "b");
        devInfo.setStoreAvailable(TelephonyUtil.getAvailableInternalMemorySize()+"b");
        devInfo.setScreenW(TelephonyUtil.getWeith(context)+"px");
        devInfo.setScreenH(TelephonyUtil.getHeight(context)+"px");
        devInfo.setPixelDensity(new DensityUtil(context).getDmDensityDpi() +"dpi");

        return devInfo;
    }
    public static InitReq builderInitReqReq(){
        InitReq initReq = new InitReq();
        initReq.setPartnerCode(StorageManage.getInstance().getPartner_code());
        initReq.setUserAccount(StorageManage.getInstance().getUser_account());
        initReq.setDevInfo(builderDevInfoReq(StorageManage.getInstance().getmContext()));
        return initReq;
    }

    public static QualCkeckSvc getQualCkeckSvc(){
        QualCkeckSvc qualCkeckSvc = new QualCkeckSvc();
        qualCkeckSvc.setIp(StorageManage.getInstance().getIP());
        qualCkeckSvc.setParter_code(StorageManage.getInstance().getPartner_code());
        qualCkeckSvc.setTimestamp(getTimeMillis());
        return qualCkeckSvc;
    }

    public static OrderAclrSvc getOrderAclrSvc(){
        OrderAclrSvc orderAclrSvc = new OrderAclrSvc();

        orderAclrSvc.setIp(StorageManage.getInstance().getIP());
        orderAclrSvc.setPartner_code(StorageManage.getInstance().getPartner_code());
        orderAclrSvc.setUser_account(StorageManage.getInstance().getUser_account());
        orderAclrSvc.setPay_type("3");
        orderAclrSvc.setTimestamp(getTimeMillis());

        return orderAclrSvc;
    }
    public static SynOrderAclrSvc getSynOrderAclrSvc(){
        SynOrderAclrSvc synOrderAclrSvc = new SynOrderAclrSvc();

        synOrderAclrSvc.setIp(StorageManage.getInstance().getIP());
        synOrderAclrSvc.setPartner_code(StorageManage.getInstance().getPartner_code());
        synOrderAclrSvc.setUser_account(StorageManage.getInstance().getUser_account());
        synOrderAclrSvc.setTimestamp(getTimeMillis());

        return synOrderAclrSvc;
    }
    public static OrderQuerySvc getOrderQuerySvc(){
        OrderQuerySvc orderQuerySvc = new OrderQuerySvc();

        orderQuerySvc.setClassName(StorageManage.getInstance().getClassName());
        orderQuerySvc.setPartner_code(StorageManage.getInstance().getPartner_code());
        orderQuerySvc.setTimestamp(getTimeMillis());

        return orderQuerySvc;
    }

    public static StartupAclrSvc getStartupAclrSvc(){
        StartupAclrSvc startupAclrSvc = new StartupAclrSvc();

        startupAclrSvc.setClassName(StorageManage.getInstance().getClassName());
        startupAclrSvc.setIp(StorageManage.getInstance().getIP());
        startupAclrSvc.setPartner_code(StorageManage.getInstance().getPartner_code());
        startupAclrSvc.setUser_account(StorageManage.getInstance().getUser_account());
        startupAclrSvc.setTimestamp(getTimeMillis());

        return startupAclrSvc;
    }

    public static StopAclrSvc getStopAclrSvc(){
        StopAclrSvc stopAclrSvc = new StopAclrSvc();

        stopAclrSvc.setClassName(StorageManage.getInstance().getClassName());
        stopAclrSvc.setIp(StorageManage.getInstance().getIP());
        stopAclrSvc.setPartner_code(StorageManage.getInstance().getPartner_code());
        stopAclrSvc.setTimestamp(getTimeMillis());

        return stopAclrSvc;
    }

    public static StateQuerySvc getStateQuerySvc(){
        StateQuerySvc stateQuerySvc = new StateQuerySvc();

        stateQuerySvc.setClassName(StorageManage.getInstance().getClassName());
        stateQuerySvc.setIp(StorageManage.getInstance().getIP());
        stateQuerySvc.setPartner_code(StorageManage.getInstance().getPartner_code());
        stateQuerySvc.setTimestamp(getTimeMillis());

        return stateQuerySvc;
    }

    private static String getTimeMillis(){
        return System.currentTimeMillis() +"";
    }
    public static int getPackketType(Context context){
        String net = NetworkUtil.getNetworkType(context);
        if ("4G".equals(net)){
            return 1;
        }else if ("WIFI".equals(net)){
            return 2;
        }else {
            return 0;
        }
    }
}
