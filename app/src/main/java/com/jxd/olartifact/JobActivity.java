package com.jxd.olartifact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JobActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button btn;
    @BindView(R.id.etConfig)
    EditText etConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        ButterKnife.bind(this);

        String json = PreferenceHelper.readString(this, Variable.prefName, Variable.prefKey);
        etConfig.setText(json);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick(View view){
        String json = PreferenceHelper.readString(this, Variable.prefName, Variable.prefKey);
        RequestModel requestModel = new Gson().fromJson(json, RequestModel.class);
        if( requestModel==null ){
            Toast.makeText(this,"缺少配置信息",Toast.LENGTH_LONG).show();
            return;
        }

        String runtTimeStr = requestModel.getRunTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long timeStamp=0L;
        try {
            Date runTime = simpleDateFormat.parse(runtTimeStr);
            timeStamp = runTime.getTime()- System.currentTimeMillis();
        }catch (Exception ex){
            Toast.makeText(this,"无法解析时间",Toast.LENGTH_LONG).show();
            return;
        }
        if(timeStamp<1) return;
        TryJob.createTryJob( timeStamp );
        Toast.makeText(this,"闹钟设置成功",Toast.LENGTH_SHORT).show();
    }
}
