package com.gls.speed.sdk.utils;



import com.gls.speed.sdk.model.OrderQuerySvc;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TimeZone;

/*
 * 加密工具类
 */
public class EncryptUtil {
	
	public static final String PASSWORD = "testkey";
    public static String ecodes(String content, String key){
        if (content == null || content.length() < 1) {
            return null;
        }
        try {
            if (key == null) {
                System.out.print("Key为空null");
                return null;
            }
            byte[] raw = key.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] byteRresult = cipher.doFinal(content.getBytes("utf-8"));
            String encoded = Base64.encode(byteRresult);
            return encoded;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dcodes(String content1, String key) {
        byte[] content = Base64.decode(content1);
        try {
            byte[] raw = key.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = content;
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

  /*  private static long startSpeedTime;
    private  static long zero;
    public static void main(String[] args) {
            String need1=ecodes("notify_url=http%3A%2F%2F180.150.187.161%3A8089%2FtestBack&partner_code=TEST&partner_order_id=188209616741111111191&pay_type=1&product_code=TESTONE02&return_url=http%3A%2F%2Fwww.baidu.com&timestamp=1523536829329&user_account=18820961673","fybsigntest12345");
            System.out.println("need1-----"+need1);
            String need=dcodes("0isP4adNyLS26gAUmBLgw2+9AZ2PUgRNOv3X8yLqMFRif2K/izzwMfsmqZaFgq/x5q/7BeV9drkh6XWnghEVzfaWsW8Bw0NJWgyTeaqpesniKoGDKLCbkvznRk6oiHYhhHOf4y9fPwRBbZrkv6t+nYxdrcq0ySScvgOLpDM8ZkG94s5gbFdC5xIHOeHRIVbkB0fnO1QBvTop3z2Ot55Sr20bYRl9/9lG7PUvY6dbd1yOKzOTwliorkEHiYXFKztAYithdO+/vAwMmPu3W5l9ayoCAIDpVkPOXOAgxg6LstKBNkzI61J/TMkRVp+EPy2wecYkuiQDgZcyuyeTylSq5lDAMd/9u2oquYZ3lUqNlpNt1LH5nWuwDQANM9uRwBSRudoeHoR5YxlUQGLoEw6BtQ==","fybsigntest12345");
        startSpeedTime = System.currentTimeMillis();
        zero = startSpeedTime / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
            System.out.println("zero-----"+zero);
        testOrderQuerySvcSvc();
    }
    private String orderQuerySvcUrl = "http://kdjs.fangyb.com:8088/orderQuerySvc";


    public static void testOrderQuerySvcSvc() {
        OrderQuerySvc req = new OrderQuerySvc();
        req.setClassName("OneCtOperator");
        req.setOrder_id("20180404172438072KDA-458196870000000");
        req.setPartner_code("TEST");
        req.setTimestamp(""+System.currentTimeMillis());
        Map s = DataJsonTranslation.objectToMap(req);

        System.out.println("s -----"+s);
        EncryptUtil encryptUtil =new EncryptUtil();
        SortUtil  sortUtil=new SortUtil();


        String needString1=sortUtil.formatUrlMap(s,false,false);
        System.out.println("needString1 -----"+needString1);
        s.put("sign",encryptUtil.ecodes(needString1,"fybsigntest12345"));

    }*/
}