package com.gls.speed.sdk.model;


/**
 * @Author:GLR
 * @Date:Created in 2017/11/29 10:16.
 * @Description:
 */
public class DevInfo {
    private String uuid;
    private String mac;
    private String imsi;
    private String imei;
    private int osType;//系统类型 1 Android 2 ios 3 web 4 pc
    private String osVersion;//系统版本号
    private String appVersion;//当前版本号
    private String sdkVersion;//当前sdk版本号

    private String brand;//手机厂商
    private String model;//机型
    private String networkType;// 1 WIFI, 2 4G, 3 3G, 4 2G
   // @JsonProperty
    private String SSID;//wifi标识
    private String signalStrength;//信号强度 数字+单位
    private String androidId;
    private String idfa;
    private String cpu;
    private String ram;
    private String storeUsed;//存储已用 数字+单位
    private String storeAvailable;//存储可用 数字+单位
    private String screenW;//屏幕宽度 数字+单位
    private String screenH;//屏幕高度 数字+单位
    private String pixelDensity;//像素密度 数字+单位

    //以下字段不用传
    private String ip;

    public String getSdkVersion(){return sdkVersion;}
    public void setSdkVersion(String sdkVersion){this.sdkVersion=sdkVersion; }

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public String getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(String signalStrength) {
        this.signalStrength = signalStrength;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getOsType() {
        return osType;
    }

    public void setOsType(int osType) {
        this.osType = osType;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStoreUsed() {
        return storeUsed;
    }

    public void setStoreUsed(String storeUsed) {
        this.storeUsed = storeUsed;
    }

    public String getStoreAvailable() {
        return storeAvailable;
    }

    public void setStoreAvailable(String storeAvailable) {
        this.storeAvailable = storeAvailable;
    }

    public String getScreenW() {
        return screenW;
    }

    public void setScreenW(String screenW) {
        this.screenW = screenW;
    }

    public String getScreenH() {
        return screenH;
    }

    public void setScreenH(String screenH) {
        this.screenH = screenH;
    }

    public String getPixelDensity() {
        return pixelDensity;
    }

    public void setPixelDensity(String pixelDensity) {
        this.pixelDensity = pixelDensity;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DevInfo{");
        sb.append("uuid='").append(uuid).append('\'');
        sb.append(", mac='").append(mac).append('\'');
        sb.append(", imsi='").append(imsi).append('\'');
        sb.append(", imei='").append(imei).append('\'');
        sb.append(", osType=").append(osType);
        sb.append(", osVersion='").append(osVersion).append('\'');
        sb.append(", appVersion='").append(appVersion).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", networkType='").append(networkType).append('\'');
        sb.append(", SSID='").append(SSID).append('\'');
        sb.append(", signalStrength='").append(signalStrength).append('\'');
        sb.append(", androidId='").append(androidId).append('\'');
        sb.append(", idfa='").append(idfa).append('\'');
        sb.append(", cpu='").append(cpu).append('\'');
        sb.append(", ram='").append(ram).append('\'');
        sb.append(", storeUsed='").append(storeUsed).append('\'');
        sb.append(", storeAvailable='").append(storeAvailable).append('\'');
        sb.append(", screenW='").append(screenW).append('\'');
        sb.append(", screenH='").append(screenH).append('\'');
        sb.append(", pixelDensity='").append(pixelDensity).append('\'');
        sb.append(", ip='").append(ip).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
