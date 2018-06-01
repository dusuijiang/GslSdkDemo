package com.gls.speed.sdk.utils;

import android.os.Environment;

import com.gls.speed.sdk.model.OrderQuerySvc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class SaveFileUtils {
    private static String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/CatalogData";
    public static List<OrderQuerySvc> readLogFile() {
        File dir=new File(path);
        if(!dir.isDirectory()){
            dir.mkdir();
        }
        File file= new File(path+"/catalogdata.txt");
        List<OrderQuerySvc> logModelList = null;
        ObjectInputStream oin = null;
        if (file.exists()){
            try {
                oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                logModelList = (List<OrderQuerySvc>) oin.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (oin != null){
                        oin.close();
                    }
                }catch (IOException e){

                }

            }
        }
        return logModelList;
    }

    public void writeLogFile(OrderQuerySvc logModelList) {
        File dir=new File(path);
        if(!dir.isDirectory()){
            dir.mkdir();
        }
        File file= new File(path+"/catalogdata.txt");

        List<OrderQuerySvc> modelList = readLogFile();

        if (modelList == null){
            modelList = new ArrayList<>();
        }
        modelList.add(logModelList);
        ObjectOutputStream oout = null;

        try {
            oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            oout.writeObject(modelList);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (oout != null){
                    oout.close();
                }
            }catch (IOException e){

            }
        }
    }
}
