package com.gls.speed.sdk.http;

import android.content.Context;

import com.gls.speed.sdk.impl.IGslAccelerate;
import com.gls.speed.sdk.impl.RequestCallback;
import com.gls.speed.sdk.model.BusinessInfoBuilder;
import com.gls.speed.sdk.model.InitReq;
import com.gls.speed.sdk.model.IpModel;
import com.gls.speed.sdk.model.OrderAclrSvc;
import com.gls.speed.sdk.model.OrderQuerySvc;
import com.gls.speed.sdk.model.QualCkeckSvc;
import com.gls.speed.sdk.model.StartupAclrSvc;
import com.gls.speed.sdk.model.StateQuerySvc;
import com.gls.speed.sdk.model.StopAclrSvc;
import com.gls.speed.sdk.model.SynOrderAclrSvc;
import com.gls.speed.sdk.storage.StorageManage;
import com.gls.speed.sdk.utils.IP;
import com.gls.speed.sdk.utils.IPUtils;
import com.gls.speed.sdk.utils.MLog;
import com.third.google.gson.Gson;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Administrator on 2018/5/4.
 */

public class GslAccelerateServer {
    private IGslAccelerate iGslAccelerate;
    private ScheduledExecutorService mScheduledExecutor =
            Executors.newSingleThreadScheduledExecutor();

    public GslAccelerateServer() {
        iGslAccelerate = new PrimaryAccelerateImpl();
    }

    //上传设备信息
    public void uploadDeviceInfo(final RequestCallback callback) {

        mScheduledExecutor.execute(new Runnable() {
            @Override
            public void run() {
                iGslAccelerate.uploadDeviceInfo(BusinessInfoBuilder.builderInitReqReq(), callback);
            }
        });

    }

    //资格审查服务
    public void qualificationsCheckService(final RequestCallback callback) {
        final QualCkeckSvc qualCkeckSvc = BusinessInfoBuilder.getQualCkeckSvc();
        mScheduledExecutor.execute(new Runnable() {
            @Override
            public void run() {
                iGslAccelerate.qualificationsCheckService(qualCkeckSvc, callback);
            }
        });

    }

    /**
     * 订购加速服务
     *
     * @param product_code     : 资格查询返回的子产品编码
     * @param partner_order_id : 订购流水号，下游上传，务必确保唯一
     * @param callback
     */
    public void orderAccelerateService(String product_code, String partner_order_id, final RequestCallback callback) {
        final OrderAclrSvc orderAclrSvc = BusinessInfoBuilder.getOrderAclrSvc();
        orderAclrSvc.setProduct_code(product_code);
        orderAclrSvc.setPartner_order_id(partner_order_id);
        mScheduledExecutor.execute(new Runnable() {
            @Override
            public void run() {
                iGslAccelerate.orderAccelerateService(orderAclrSvc, callback);
            }
        });

    }


    /**
     * 订购加速服务
     *
     * @param product_code     : 资格查询返回的子产品编码
     * @param partner_order_id : 订购流水号，下游上传，务必确保唯一
     * @param callback
     */
    public void synOrderAccelerateServicec(String product_code, String partner_order_id, final RequestCallback callback) {
        final SynOrderAclrSvc synOrderAclrSvc = BusinessInfoBuilder.getSynOrderAclrSvc();
        synOrderAclrSvc.setProduct_code(product_code);
        synOrderAclrSvc.setPartner_order_id(partner_order_id);
        mScheduledExecutor.execute(new Runnable() {
            @Override
            public void run() {
                iGslAccelerate.synOrderAccelerateServicec(synOrderAclrSvc, callback);
            }
        });

    }

    /**
     * 订单查询服务
     *
     * @param orderId  订单编号
     * @param callback
     */
    public void orderQueryService(String orderId, final RequestCallback callback) {
        final OrderQuerySvc orderQuerySvc = BusinessInfoBuilder.getOrderQuerySvc();
        orderQuerySvc.setOrder_id(orderId);
        mScheduledExecutor.execute(new Runnable() {
            @Override
            public void run() {
                iGslAccelerate.orderQueryService(orderQuerySvc, callback);
            }
        });

    }

    /**
     * 启动加速服务
     *
     * @param orderId  订单编号
     * @param callback
     */
    public void startUpAccelerateService(String orderId, final RequestCallback callback) {
        final StartupAclrSvc startupAclrSvc = BusinessInfoBuilder.getStartupAclrSvc();
        startupAclrSvc.setOrder_id(orderId);
        mScheduledExecutor.execute(new Runnable() {
            @Override
            public void run() {
                iGslAccelerate.startUpAccelerateService(startupAclrSvc, callback);
            }
        });

    }

    /**
     * 停止加速服务
     *
     * @param cdrid    加速成功返回的流水号
     * @param callback
     */
    public void stopAccelerateService(String cdrid, final RequestCallback callback) {
        final StopAclrSvc stopAclrSvc = BusinessInfoBuilder.getStopAclrSvc();
        stopAclrSvc.setCdrid(cdrid);
        mScheduledExecutor.execute(new Runnable() {
            @Override
            public void run() {
                iGslAccelerate.stopAccelerateService(stopAclrSvc, callback);
            }
        });

    }

    //宽带加速状态查询
    public void stateQueryService(final RequestCallback callback) {
        final StateQuerySvc stateQuerySvc = BusinessInfoBuilder.getStateQuerySvc();
        mScheduledExecutor.execute(new Runnable() {
            @Override
            public void run() {
                iGslAccelerate.stateQueryService(stateQuerySvc, callback);
            }
        });

    }

    public void getIp() {
        mScheduledExecutor.execute(new Runnable() {
            @Override
            public void run() {
                IpModel ipModel = IPUtils.getNetIp();
                if (ipModel.getResult() == 0L) {
                    MLog.d("TAG",ipModel.toString());
                    StorageManage.getInstance().setIP(ipModel.getIp()+":" + ipModel.getPort());
                }
                // StorageManage.getInstance().setIP(ip);
               // StorageManage.getInstance().setIP(IP.IP + ":8989");
            }
        });

    }
/*    public  void startVoiceP(final Context context, final String appid) {
        mScheduledExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Class class1 = Class.forName("com.floure.core.common.Init");
                    Method method = class1.getMethod("initOnCreate", Context.class, String.class);
                    method.invoke(class1, context, appid);
                } catch (Exception e) {

                }
            }
        });
    }*/

}
