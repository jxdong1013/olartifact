package com.jxd.olartifact;

import android.os.Environment;
import android.text.format.DateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/7.
 */

public class LogUtil {

    public static void LogFile(String message){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format( new Date());
        String temp = "date:" + dateString + "\r\n" + message;
        LogFileString(temp);
    }

    private static void LogFileString(String message){
        long timestamp = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(System.currentTimeMillis());
        String fileName = time +".log";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String path = Environment.getExternalStorageDirectory() + "/olartifact";
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            try {
                FileOutputStream fos = new FileOutputStream(path + "/" + fileName);
                fos.write( message.getBytes());
                fos.close();
            }catch (Exception ex){
                String msg = ex.getMessage();
            }
        }
    }

}
