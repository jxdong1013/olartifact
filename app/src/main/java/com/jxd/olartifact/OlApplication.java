package com.jxd.olartifact;

import android.app.Application;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;
import com.evernote.android.job.JobManager;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2017/8/8.
 */

public class OlApplication extends Application {



    @Override
    public void onCreate() {
        super.onCreate();


        Fresco.initialize(this);

        JobManager.create(this).addJobCreator(new TryJobCreator());

        //加载异常处理模块
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }
}
