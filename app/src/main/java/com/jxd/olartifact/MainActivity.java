package com.jxd.olartifact;

import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.userId)
    EditText userid;
    @BindView(R.id.productId)
    EditText productid;
    @BindView(R.id.specifId)
    EditText specid;
    @BindView(R.id.addressId)
    EditText addressid;
    @BindView(R.id.appkey)
    EditText appkey;
    @BindView(R.id.appsecret)
    EditText appsecret;
    @BindView(R.id.noneStr)
    EditText nonestr;
    @BindView(R.id.timestamp)
    EditText timestamp;
    @BindView(R.id.version)
    EditText version;
    @BindView(R.id.payMethod)
    EditText payMethod;
    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.post)
    Button post;

    int num=1;
    String memo="";
    int uutype=2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //nonestr.setText(StringUtils.getRandomString(8));
        nonestr.setText("637th3yd");
        appkey.setText("uwd1c0sxdoyn1");
        appsecret.setText("wBH4YJUYIa6a");
        userid.setText("545142");
        addressid.setText("52962");
        productid.setText("");
        timestamp.setText("1502029072");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @OnClick(R.id.post)
    public void post(View v){

        Variable.version = version.getText().toString();

        long pid= Long.valueOf( productid.getText().toString());
        Integer speid=null;
        if( specid.getText()==null || specid.getText().toString().length()==0){
            speid=null;
        }else {
            speid = Integer.valueOf(specid.getText().toString());
        }
        long uid = Long.valueOf(userid.getText().toString());
        int aid = Integer.valueOf( addressid.getText().toString());
        int pmethod = Integer.valueOf( payMethod.getText().toString() );
        String paypassword =null;
        Integer pledgeMethod=null;

        HttpClient.getHttpAdapter()
                .buyNowCreateOrder( pid , num , paypassword , speid , uid , aid , pmethod , pledgeMethod ,memo ,  uutype)
                .enqueue(new Callback<ResultDO<PayInfo>>() {
                    @Override
                    public void onResponse(Call<ResultDO<PayInfo>> call, Response<ResultDO<PayInfo>> paramResponse) {
                        if ((paramResponse.body() != null) )

                            result.setText( paramResponse.body().toString() );
//                            if ((((ResultDO)paramResponse.body()).getCode() != 0) || (((ResultDO)paramResponse.body()).getResult() == null))
//                            {
//                                result.setText( ((ResultDO)paramResponse.body()).getMessage());
//                            }
//                            else
//                            {
//
//                            }
                    }


                    @Override
                    public void onFailure(Call<ResultDO<PayInfo>> call, Throwable t) {
                        result.setText( t.getMessage() );
                    }
                });

    }
}
