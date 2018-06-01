package com.gls.speed.sdk.config;


/**
 * Created by dengjun on 2017/10/16.
 */

public class UrlBuilder {
    private static UrlBuilder instance = null;
    private UrlConfig mUrlConfig;
    public static UrlBuilder getInstance(){
        if (instance == null){
            synchronized (UrlBuilder.class){
                if (instance == null){
                    instance = new UrlBuilder();
                }
            }
        }
        return instance;
    }

    public void init(UrlConfig urlConfig){
        this.mUrlConfig = urlConfig;
    }

    private UrlBuilder() {

    }

    public String getReqUrl(){
        return mUrlConfig.getHttpUrl();
    }
    public String getInitReqUrl(){
        return mUrlConfig.getHttpUrl()+"/app/init";
    }

    public String getOrderAclrSvc(){
        return mUrlConfig.getGlsHttpUrl()+"/orderAclrSvc";
    }

    public String getOrderQuerySvc(){
        return mUrlConfig.getGlsHttpUrl()+"/orderQuerySvc";
    }

    public String getPaySvc(){
        return mUrlConfig.getGlsHttpUrl()+"/paySvc?";
    }

    public String getQualCkeckSvc(){
        return mUrlConfig.getGlsHttpUrl()+"/qualCheckSvc";
    }

    public String getStartupAclrSvc(){
        return mUrlConfig.getGlsHttpUrl()+"/startupAclrSvc";
    }

    public String getStateQuerySvc(){
        return mUrlConfig.getGlsHttpUrl()+"/stateQuerySvc";
    }
    public String getStopAclrSvc(){
        return mUrlConfig.getGlsHttpUrl()+"/stopAclrSvc";
    }

    public String getSynOrderAclrSvc(){
        return mUrlConfig.getGlsHttpUrl()+"/synOrderAclrSvc";
    }

    public String getIpUrl(){
        return mUrlConfig.getHttpUrl()+"/get/address";
    }
}
