package com.jxd.olartifact;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

/**
 * Created by Administrator on 2017/8/10.
 */

public class TryJobCreator implements JobCreator {

    @Override
    public Job create(String tag) {

        switch ( tag ){
            case TryJob.TAG:
                return new TryJob();
            default:
                return null;
        }
    }
}
