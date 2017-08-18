package com.jxd.olartifact;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;

import java.util.Date;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Administrator on 2017/8/10.
 */

public class TryJob extends Job {

    public static final String TAG="JxdTryJob";

    @NonNull
    @Override
    protected Result onRunJob(Params params) {

//        Intent receiveIntent = new Intent();
//        receiveIntent.setAction("com.jxd.olartifact.try");
//        receiveIntent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast( getContext() , 0 ,receiveIntent , 0);
//
//        AlarmManager alarmManager = (AlarmManager) this.getContext().getSystemService(ALARM_SERVICE);
//        alarmManager.cancel( pendingIntent );

//        Intent rintent = new Intent();
//        rintent.setAction("com.jxd.olartifact.try");
//        getContext().sendBroadcast(rintent);

        //LogUtil.LogFile("-----background job starting-----");

        Intent intent = new Intent();
        intent.setClass(getContext(), TryService.class);
        getContext().startService( intent);

        return Result.SUCCESS;
    }


    public static void createTryJob( Long timeStamp ){

        int id = new JobRequest.Builder( TryJob.TAG  )
                .setExact( timeStamp )
                .setBackoffCriteria( 5_000L , JobRequest.BackoffPolicy.LINEAR)
                .setPersisted(true)
                //.setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
                //.setRequiresDeviceIdle(true)
                .setUpdateCurrent(true)
                .build()
                .schedule();
    }

}
