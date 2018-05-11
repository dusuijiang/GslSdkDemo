package com.gls.speed.sdk.base;

import java.util.HashMap;
import java.util.Map;

public class Result {
    public static final Long RESULT_FAIL = -1L;
    public static final Long RESULT_OK = 0L;
    public static final Long RESULT_STOP = 1L;
    public static final Long RESULT_ERR_PARAM = 2L;
    public static final Long RESULT_ERR_SYSTEM = 3L;
    public static final Long RESULT_ERR_THIRD_SYSTEM = 4L;
    public static final Long RESULT_PHONE_NOT_SUPPORT= 5L;
    public static final Long RESULT_PROVINCE_LIMIT= 6L;
    public static final Long RESULT_LOCATION_NOT_MATCH= 7L;
    public static final Long RESULT_ERR_ORDER= 8L;
    public static final Long ERR_SMS_PHONE_OVERTIMES = 9L;
    public static final Long ERR_SMS_APP_OVERTIMES = 10L;
    public static final Long ERR_ORDER_NOT_FOUND = 11L;
    public static final Long ERR_SMS_CODE = 12L;
    public static final Long ERR_EXISTS_ORDER = 13L;
    public static final Long ERR_PRICE_NOT_MATCH = 14L;
    public static final Long ERR_CANNOT_BUY_TIMES = 15L;
    public static final Long ERR_CANNOT_BUY_APPID = 16L;
    public static final Long ERR_SYSTEM_BUSY = 17L;
    public static final Long ERR_ORDER_INVALIS= 18L;
    public static final Long ERR_CANNOT_APPID= 19L;
    
    public static final Long RESULT_PHONE_NOT_SUPPORT_ROAM= 20L;
    public static final Long RESULT_PROVINCE_LIMIT_ROAM= 21L;
    public static final Long RESULT_REGION_NOT= 22L;
    public static final Long RESULT_REGION_NOT_PACKET= 23L;
    public static final Long RESULT_ORDERCHECK_NOT_PACKET= 24L;
    public static final Long RESULT_ORDERCHECK_NOT_IP= 25L;
    
    private static Map<Long, String> errorMsgs = new HashMap<Long, String>();

    static {
        errorMsgs.put(RESULT_OK, "成功.");
        errorMsgs.put(RESULT_FAIL, "失败.");
        errorMsgs.put(RESULT_ERR_PARAM, "提交参数错误.");
        errorMsgs.put(RESULT_ERR_SYSTEM, "系统错误,请稍后重试.");
        errorMsgs.put(RESULT_ERR_THIRD_SYSTEM, "第三方系统错误.");
        
        errorMsgs.put(RESULT_PHONE_NOT_SUPPORT, "您输入的手机号码{运营商}暂不支持开通该业务，请输入有效的号码");
        errorMsgs.put(RESULT_PROVINCE_LIMIT, "手机号码所属地区暂不支持开通流量加速服务");
        errorMsgs.put(RESULT_REGION_NOT, "该地区暂不支持开通流量加速服务");
        errorMsgs.put(RESULT_REGION_NOT_PACKET, "该地区暂不支持开通改套餐");
        //不支持漫游
        errorMsgs.put(RESULT_PHONE_NOT_SUPPORT_ROAM, "您输入的手机号码{运营商}只能在号码所属地区{地区}省内使用，请确定是否需要开通。");
        errorMsgs.put(RESULT_PROVINCE_LIMIT_ROAM, "手机号码只能在号码所属地区{地区}省内使用，请确定是否需要开通。");
        
        errorMsgs.put(RESULT_LOCATION_NOT_MATCH, "您购买的加速包只能在号码所属地区{地区}省内使用，请确定是否需要开通。");
        
        errorMsgs.put(RESULT_ERR_ORDER, "保存订单错误");
        errorMsgs.put(ERR_SMS_PHONE_OVERTIMES, "该手机号请求获取短信次数过多，请明天再试哦.");
        errorMsgs.put(ERR_SMS_APP_OVERTIMES, "该设备请求获取短信次数过多，请明天再试哦.");
        errorMsgs.put(ERR_ORDER_NOT_FOUND, "暂未检测到您的业务信息");
        errorMsgs.put(ERR_SMS_CODE, "验证码输入不正确.");
        errorMsgs.put(ERR_EXISTS_ORDER, "该手机号存在订购单");
        errorMsgs.put(ERR_PRICE_NOT_MATCH, "价格有误");
        errorMsgs.put(RESULT_STOP, "服务暂停");
        errorMsgs.put(ERR_CANNOT_BUY_TIMES, "无法多次购买");
        errorMsgs.put(ERR_CANNOT_BUY_APPID, "该订单不需要获取appid");
        errorMsgs.put(ERR_SYSTEM_BUSY, "请求频繁.");
        errorMsgs.put(ERR_ORDER_INVALIS, "订单失效.");
        errorMsgs.put(ERR_CANNOT_APPID, "appid不存在或已失效.");
        errorMsgs.put(RESULT_ORDERCHECK_NOT_PACKET, "该体验包每个用户限定购买一次.");
        errorMsgs.put(RESULT_ORDERCHECK_NOT_IP, "ip获取失败.");
    }

    public static String getMsg(Long key) {
        return errorMsgs.get(key);
    }
}
