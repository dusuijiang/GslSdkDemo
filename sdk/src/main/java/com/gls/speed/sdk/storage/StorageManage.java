package com.gls.speed.sdk.storage;

import android.content.Context;

import com.gls.speed.sdk.utils.SharedPreferencesUtil;


/**
 * Created by dengjun on 2017/10/17.
 */

public class StorageManage {
    private static final String KEY_SOURCE_IP = "source_ip";
    private static StorageManage instance = null;
    private Context mContext;
    private String partner_code;
    private String user_account;
    private String key;
    private static final String KEY_CLASS_NAME = "classname";
    private static final String KEY_PRODUCT_CODE = "product_code";
    private static final String KEY_RESCDRID = "rescdrid";
    private static final String KEY_ORDID = "ordid";
    private static final String KEY_URL = "url";
    public static StorageManage getInstance() {
        if (instance == null) {
            synchronized (StorageManage.class) {
                if (instance == null) {
                    instance = new StorageManage();
                }
            }
        }
        return instance;
    }

    private StorageManage() {
    }

    public void init(Context context,String partner_code, String user_account, String key) {
        this.mContext = context;
        this.partner_code = partner_code;
        this.user_account = user_account;
        this.key = key;
    }

    public Context getmContext() {
        return mContext;
    }

    public String getPartner_code() {
        return partner_code;
    }

    public String getUser_account() {
        return user_account;
    }

    public String getKey() {
        return key;
    }

    public void setIP(String ip) {
        if (mContext != null) {
            SharedPreferencesUtil.putStringValue(mContext, KEY_SOURCE_IP, ip);
        }
    }

    public void setClassName(String className){
        if (mContext != null){
            SharedPreferencesUtil.putStringValue(mContext, KEY_CLASS_NAME, className);
        }
    }

    public String getClassName(){
        if (mContext != null) {
            return SharedPreferencesUtil.getStringValue(mContext, KEY_CLASS_NAME, "");
        }
        return "";
    }

    public String getIP() {
        if (mContext != null) {
            return SharedPreferencesUtil.getStringValue(mContext, KEY_SOURCE_IP, "");
        }
        return "";
    }

    public void setKeyProductCode(String product_code){
        if (mContext != null){
            SharedPreferencesUtil.putStringValue(mContext, KEY_PRODUCT_CODE, product_code);
        }
    }

    public String getKeyProductCode(){
        if (mContext != null) {
            return SharedPreferencesUtil.getStringValue(mContext, KEY_PRODUCT_CODE, "");
        }
        return "";
    }

    public void setResCDRID(String resCDRID){
        if (mContext != null){
            SharedPreferencesUtil.putStringValue(mContext, KEY_RESCDRID, resCDRID);
        }
    }

    public String getResCDRID(){
        if (mContext != null) {
            return SharedPreferencesUtil.getStringValue(mContext, KEY_RESCDRID, "");
        }
        return "";
    }

    public void setOrdid(String ordid){
        if (mContext != null){
            SharedPreferencesUtil.putStringValue(mContext, KEY_ORDID, ordid);
        }
    }

    public String getOrdid(){
        if (mContext != null) {
            return SharedPreferencesUtil.getStringValue(mContext, KEY_ORDID, "");
        }
        return "";
    }

    public void setUrl(String url){
        if (mContext != null){
            SharedPreferencesUtil.putStringValue(mContext, KEY_URL, url);
        }
    }

    public String getUrl(){
        if (mContext != null) {
            return SharedPreferencesUtil.getStringValue(mContext, KEY_URL, "");
        }
        return "";
    }
}
