package com.gls.speed.sdk;

import android.content.Context;

import com.gls.speed.sdk.config.ProductUrlConfig;
import com.gls.speed.sdk.config.UrlBuilder;
import com.gls.speed.sdk.http.GslAccelerateServer;
import com.gls.speed.sdk.impl.RequestCallback;
import com.gls.speed.sdk.resp.GslCheckResp;
import com.gls.speed.sdk.resp.GslOrderQueryResp;
import com.gls.speed.sdk.resp.GslOrderResp;
import com.gls.speed.sdk.resp.GslStartupResp;
import com.gls.speed.sdk.resp.GslStateQueryResp;
import com.gls.speed.sdk.resp.GslStopResp;
import com.gls.speed.sdk.storage.StorageManage;
import com.gls.speed.sdk.utils.MLog;


/**
 * Created by Administrator on 2018/5/4.
 */

public class GslAccelerate {

    private String partner_code;
    private String user_account;
    private String key;
    private Context context;
    private GslAccelerateServer gslAccelerateServer;
    private GslAccelerate() {
        UrlBuilder.getInstance().init(new ProductUrlConfig());
        gslAccelerateServer = new GslAccelerateServer();
        gslAccelerateServer.getIp();
    }

    private static class SingletonHolder {
        private static final GslAccelerate instance = new GslAccelerate();
    }

    public static GslAccelerate getInstance() {
        return SingletonHolder.instance;
    }


    /**
     * 初始化
     * @param context  上下文
     * @param partner_code  渠道编码
     * @param user_account 用户账号
     * @param key 平台分配的key
     */
    public void glsAccelerateInit(Context context,String partner_code, String user_account, String key) {
        this.partner_code = partner_code;
        this.user_account = user_account;
        this.key = key;
        this.context = context;
        StorageManage.getInstance().init(context,partner_code,user_account,key);
        //gslAccelerateServer.startVoiceP(context,key);
        gslAccelerateServer.uploadDeviceInfo(new RequestCallback() {
            @Override
            public void onResult(Object result) {
                MLog.d("TAG" + result);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    /**
     * 资格审查服务
     * @param callback 接收回调的数据
     */
    public void qualificationsCheckService(RequestCallback<GslCheckResp> callback) {
        gslAccelerateServer.qualificationsCheckService(callback);
    }

    /**
     *订购加速服务
     * @param product_code       资格查询返回的子产品编码
     * @param partner_order_id   订购流水号，下游上传，务必确保唯一
     * @param callback 接收回调的数据
     */
    private void orderAccelerateService(String product_code,String partner_order_id, RequestCallback callback) {
        gslAccelerateServer.orderAccelerateService(product_code,partner_order_id,callback);
    }

    /**
     * 订购加速服务
     * @param product_code      资格查询返回的子产品编码
     * @param partner_order_id  订购流水号，下游上传，务必确保唯一
     * @param callback 接收回调的数据
     */
    public void synOrderAccelerateServicec(String product_code,String partner_order_id, RequestCallback<GslOrderResp> callback) {
        gslAccelerateServer.synOrderAccelerateServicec(product_code,partner_order_id,callback);
    }

    /**
     * 订单查询服务
     * @param orderId  订单编号
     * @param callback 接收回调的数据
     */
    public void orderQueryService(String orderId, RequestCallback<GslOrderQueryResp> callback) {
        gslAccelerateServer.orderQueryService(orderId,callback);
    }

    /**
     * 启动加速服务
     * @param orderId  订单编号
     * @param callback 接收回调的数据
     */
    public void startUpAccelerateService(String orderId, RequestCallback<GslStartupResp> callback) {
        gslAccelerateServer.startUpAccelerateService(orderId,callback);
    }

    /**
     * 停止加速服务
     * @param cdrid 加速成功返回的流水号
     * @param callback 接收回调的数据
     */
    public void stopAccelerateService(String cdrid, RequestCallback<GslStopResp> callback) {
        gslAccelerateServer.stopAccelerateService(cdrid,callback);
    }

    /**
     * 宽带加速状态查询
     * @param callback 接收回调的数据
     */
    public void stateQueryService(RequestCallback<GslStateQueryResp> callback) {
        gslAccelerateServer.stateQueryService(callback);
    }

}
