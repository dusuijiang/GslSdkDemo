package com.gls.speed.sdkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gls.speed.sdk.GslAccelerate;
import com.gls.speed.sdk.impl.RequestCallback;
import com.gls.speed.sdk.resp.GslCheckResp;
import com.gls.speed.sdk.resp.GslOrderQueryResp;
import com.gls.speed.sdk.resp.GslOrderResp;
import com.gls.speed.sdk.resp.GslStartupResp;
import com.gls.speed.sdk.resp.GslStateQueryResp;
import com.gls.speed.sdk.resp.GslStopResp;
import com.gls.speed.sdk.storage.StorageManage;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;

    private TextView tv0;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

    }

    private void initView() {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        tv0 = findViewById(R.id.tv0);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                GslAccelerate.getInstance().glsAccelerateInit(this, "TEST", "dusuijiang001", "fybsigntest12345");
                break;
            case R.id.btn1:
                GslAccelerate.getInstance().qualificationsCheckService(new RequestCallback<GslCheckResp>() {
                    @Override
                    public void onResult(final GslCheckResp result) {
                        StorageManage.getInstance().setKeyProductCode(result.getProductList().get(0).getProductCode());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv0.setText("请求参数 ： "+StorageManage.getInstance().getUrl());
                                tv1.setText("资格判断 ： "+result.toString());
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
                break;
            case R.id.btn2:
                long s0 = new Random().nextLong();
                long s1 = new Random().nextLong();

                GslAccelerate.getInstance().synOrderAccelerateServicec(StorageManage.getInstance().getKeyProductCode(), s0 + "010111" + s1, new RequestCallback<GslOrderResp>() {
                    @Override
                    public void onResult(final GslOrderResp result) {

                        if (result.getResCode() == 10000L) {
                            StorageManage.getInstance().setOrdid(result.getOrderId());
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv0.setText("请求参数 ： "+StorageManage.getInstance().getUrl());
                                tv2.setText("订购服务 ： "+result.toString());
                            }
                        });

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
                break;
            case R.id.btn3:
                GslAccelerate.getInstance().orderQueryService(StorageManage.getInstance().getOrdid(), new RequestCallback<GslOrderQueryResp>() {
                    @Override
                    public void onResult(final GslOrderQueryResp result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv0.setText("请求参数 ： "+StorageManage.getInstance().getUrl());
                                tv3.setText("订单查询 ： "+result.toString());
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
                break;
            case R.id.btn4:
                GslAccelerate.getInstance().startUpAccelerateService(StorageManage.getInstance().getOrdid(), new RequestCallback<GslStartupResp>() {
                    @Override
                    public void onResult(final GslStartupResp result) {

                        if (result.getResCode() == 10000L)
                            StorageManage.getInstance().setResCDRID(result.getCdrid());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv0.setText("请求参数 ： "+StorageManage.getInstance().getUrl());
                                tv4.setText("启动加速 ： "+result.toString());
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
                break;
            case R.id.btn5:
                GslAccelerate.getInstance().stopAccelerateService(StorageManage.getInstance().getResCDRID(), new RequestCallback<GslStopResp>() {
                    @Override
                    public void onResult(final GslStopResp result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv0.setText("请求参数 ： "+StorageManage.getInstance().getUrl());
                                tv5.setText("停止加速 ： "+result.toString());
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
                break;
            case R.id.btn6:
                GslAccelerate.getInstance().stateQueryService(new RequestCallback<GslStateQueryResp>() {
                    @Override
                    public void onResult(final GslStateQueryResp result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv0.setText("请求参数 ： "+StorageManage.getInstance().getUrl());
                                tv6.setText("状态查询 ： "+result.toString());
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
                break;
        }
    }


}
