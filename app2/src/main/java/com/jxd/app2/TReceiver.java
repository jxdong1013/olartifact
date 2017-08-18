package com.jxd.app2;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

/**
 * Created by Administrator on 2017/8/11.
 */

public class TReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            createNotification(context,"sssssssssssssss");
    }

    protected void createNotification( Context context , String content  ){
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
