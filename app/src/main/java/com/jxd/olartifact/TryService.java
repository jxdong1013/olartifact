package com.jxd.olartifact;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * 该服务由闹钟触发，运行完业务逻辑，结束自己。
 * Created by Administrator on 2017/8/7.
 */
public class TryService extends Service implements Handler.Callback {
    Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        if( handler==null ){
            handler = new Handler(this);
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        if( msg.what== 9901 ){
            httpRequest();
            return true;
        }
        return false;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {

       runThread();

        return super.onStartCommand(intent, flags, startId);
    }

    private void runThread(){
        new Thread(){
            @Override
            public void run() {
                LogUtil.LogFile("----------服务开始----------");

                httpRequest();


//                Date currentDate = new Date();
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//                String c1str = simpleDateFormat.format( currentDate );
//                Date c1=new Date();
//                Date c2=new Date();
//                try {
//                     c1 = simpleDateFormat.parse(c1str);
//                }catch (Exception ex){}
//                Date runTime = requestModel.getRunTime();
//                String c2str = simpleDateFormat.format( runTime );
//                try {
//                     c2 = simpleDateFormat.parse(c2str);
//                }catch (Exception ex){}
//                while ( c1.compareTo(c2)>1 ){
//                    try {
//                        Thread.sleep(1000);
//                        c1str= simpleDateFormat.format( new Date() );
//                        c1 = simpleDateFormat.parse(c1str);
//                    }catch (Exception ex){}
//                }


            }
        }.run();
    }

    private void httpRequest(){
        String json = PreferenceHelper.readString(getApplicationContext() , Variable.prefName ,  Variable.prefKey);
        RequestModel requestModel= new Gson().fromJson(json, RequestModel.class);
        if( requestModel==null ) {
            LogUtil.LogFile("缺少配置信息,无法运行服务");
            TryService.this.stopSelf();
            return;
        }

        Variable.version = requestModel.getVersion();
        Variable.appKey =requestModel.getAppkey();
        Variable.appSecret = requestModel.getAppSecret();

        HttpClient.getHttpAdapter().buyNowCreateOrder( requestModel.getProductid() , requestModel.getNum() ,
                requestModel.getPayPassword() , requestModel.getNormalId() , requestModel.getMemberid() ,
                requestModel.getAddressid() , requestModel.getPayMethod() , requestModel.getPledgeMethod() ,
                requestModel.getMemo() , requestModel.getUuType()).enqueue(
                new Callback<ResultDO<PayInfo>>() {
                    @Override
                    public void onResponse(Call<ResultDO<PayInfo>> call, Response<ResultDO<PayInfo>> response) {
                        String json = new Gson().toJson( response.body() );
                        LogUtil.LogFile(  json );
                        ResultDO<Object> resultDO = new Gson().fromJson( json ,ResultDO.class);
                        if( resultDO!=null && resultDO.getCode() == -9901 ){
                            createNotification( resultDO.getMessage() );
                            try {
                                Thread.sleep(5000);
                            }catch (Exception ex){}
                            if( handler!=null ){
                                handler.obtainMessage(9901).sendToTarget();
                            }
                            return;
                        }

                        createNotification( json );
                        TryService.this.stopSelf();
                    }

                    @Override
                    public void onFailure(Call<ResultDO<PayInfo>> call, Throwable t) {
                        LogUtil.LogFile(  t.getMessage());
                        createNotification( t.getMessage() );
                        TryService.this.stopSelf();
                    }
                }
        );
    }

    protected void createNotification(String content  ){
        Context context =getApplicationContext();
        NotificationCompat.Builder builder = new NotificationCompat.Builder( context);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("试用提示");
        builder.setContentText(content);
        builder.setAutoCancel(true);

        Intent intent =new Intent();
        intent.setClass( context , MainActivity.class );
        intent.putExtra("notifaiction", content );
        PendingIntent pendingIntent = PendingIntent.getActivity(context , 122 , intent , PendingIntent.FLAG_UPDATE_CURRENT );
        builder.setContentIntent( pendingIntent );
        Notification notification = builder.build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

        notificationManagerCompat.notify( 100 , notification );

    }
}
