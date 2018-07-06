package com.jxd.olartifact;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.util.TimeUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.Streams;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.prefs.PreferenceChangeEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.id.list;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.jxd.olartifact.HttpClient.getHttpAdapter;
import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.userId)
    EditText userid;
    @BindView(R.id.productId)
    TextView productid;
    @BindView(R.id.productImage)
    SimpleDraweeView productImage;
    @BindView(R.id.specifId)
    TextView specid;
    @BindView(R.id.num)
     EditText num;
    @BindView(R.id.addressId)
    TextView addressid;
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
    @BindView(R.id.time)
    EditText time;
    @BindView(R.id.selectSpecif)
    TextView selectSpecif;

    @BindView(R.id.pledgeMethod_yue_3)
    RadioButton rdb_yuer_3;
    @BindView(R.id.pledgeMethod_xiaojinku_2)
    RadioButton rdb_jk_2;

    @BindView(R.id.post)
    Button post;
    @BindView(R.id.run)
    Button run;
    @BindView(R.id.save)
    Button save;

    //int num=1;
    String memo="";
    int uutype=2;
    Gson gson= new Gson();
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        nonestr.setText(StringUtils.getRandomString(8));
        appkey.setText("uwd1c0sxdoyn1");
        appsecret.setText("wBH4YJUYIa6a");
        userid.setText("545142");
        addressid.setText("");
        addressid.setTag(null);
        productid.setText("");
        productid.setTag(0);
        time.setText("10:00:00");
        //timestamp.setText("1502029072");
        timestamp.setText( valueOf(System.currentTimeMillis() / 1000L) );

        initPref();

        if( getIntent().getExtras()!=null && getIntent().getExtras().containsKey("notifaiction")){
            String content = getIntent().getExtras().getString("notifaiction");
            new AlertDialog.Builder(this).setMessage( content).show();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if( intent.getExtras()!=null && intent.getExtras().containsKey("notifaiction")){
            String content = intent.getExtras().getString("notifaiction");
            new AlertDialog.Builder(this).setMessage( content).setTitle("试用抢购提示").setNeutralButton("确定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
        }
    }

    private void initPref(){
        String json = PreferenceHelper.readString(this, Variable.prefName, Variable.prefKey);
        RequestModel requestModel = new Gson().fromJson( json , RequestModel.class);
        if( requestModel==null) return;
        userid.setText( valueOf( requestModel.getMemberid() ));
        productid.setText( valueOf( requestModel.getProductName() ));
        productid.setTag(requestModel.getProductid());
        productImage.setImageURI( requestModel.getProductImage());
        productImage.setTag( requestModel.getProductImage() );
        specid.setText( requestModel.getNormalName() == null ? "" : requestModel.getNormalName() );
        specid.setTag( requestModel.getNormalId() );

        addressid.setText( valueOf( requestModel.getAddress() ));
        addressid.setTag( requestModel.getAddressid() );
        appkey.setText( requestModel.getAppkey() );
        appsecret.setText( requestModel.getAppSecret() );
        version.setText( requestModel.getVersion() );
        num.setText( valueOf( requestModel.getNum()));
        payMethod.setText( valueOf( requestModel.getPayMethod() ));

        if( requestModel.getPledgeMethod() ==null){
            rdb_jk_2.setChecked(false);
            rdb_yuer_3.setChecked(false);
        }else{
            rdb_jk_2.setChecked( requestModel.getPledgeMethod() ==2 );
            rdb_yuer_3.setChecked( requestModel.getPledgeMethod()==3 );
        }


        if( requestModel.getRunTime() !=null ) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date runTime = simpleDateFormat.parse( requestModel.getRunTime() );
                //time.setText(simpleDateFormat.format(requestModel.getRunTime()));
                SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("HH:mm:ss");
                time.setText( simpleDateFormat1.format( runTime ));
            }catch (Exception ex){
                Toast.makeText(this,"解析时间出错",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.post)
    public void post(View v) {
        Variable.version = version.getText().toString();
        Variable.appKey = appkey.getText().toString();
        Variable.appSecret = appsecret.getText().toString();


        long pid = Long.valueOf(productid.getTag().toString());
        Integer speid;
        if (specid.getTag() == null || specid.getTag().toString().length() == 0) {
            speid = null;
        } else {
            speid = Integer.valueOf(specid.getTag().toString());
        }

        long uid = Long.valueOf(userid.getText().toString());
        int aid=0;
        try {
            aid = Integer.valueOf(addressid.getTag().toString());
        }catch (Exception ex){
            Toast.makeText(this,"请设置收货地址",Toast.LENGTH_LONG).show();
            return;
        }
        String address = addressid.getText().toString();
        int pmethod = Integer.valueOf(payMethod.getText().toString());
        String paypassword = null;
        Integer pledgeMethod = rdb_yuer_3.isChecked()? 3 : rdb_jk_2.isChecked()?2: null;

        int number = Integer.valueOf(num.getText().toString());

        getHttpAdapter()
                .buyNowCreateOrder(pid, number, paypassword, speid, uid, aid, pmethod, pledgeMethod, memo, uutype)
                .enqueue(new Callback<ResultDO<PayInfo>>() {
                    @Override
                    public void onResponse(Call<ResultDO<PayInfo>> call, Response<ResultDO<PayInfo>> paramResponse) {
                        if ((paramResponse.body() != null))
                            result.setText(gson.toJson(paramResponse.body()));
                    }

                    @Override
                    public void onFailure(Call<ResultDO<PayInfo>> call, Throwable t) {
                        result.setText(t.getMessage());
                    }
                });

    }

    @OnClick(R.id.run)
    public void run(View v){
        RequestModel requestModel=new RequestModel();
        requestModel.setAppSecret( appsecret.getText().toString() );
        requestModel.setPayPassword(null);

        Integer pledgeMethod = rdb_jk_2.isChecked()? 2: rdb_yuer_3.isChecked()?3:null;

        requestModel.setPledgeMethod(pledgeMethod);
        requestModel.setAddressid( Integer.valueOf( addressid.getTag().toString() ) );
        requestModel.setAddress( addressid.getText().toString() );
        requestModel.setAppkey(appkey.getText().toString());
        requestModel.setMemberid( Long.valueOf( userid.getText().toString() ) );
        requestModel.setMemo( memo );
        requestModel.setNum( Integer.valueOf( num.getText().toString() ));
        if(specid.getTag()==null || specid.getTag().toString().length()<1){
            requestModel.setNormalId(null);
        }else {
            requestModel.setNormalId(Integer.valueOf(specid.getTag().toString()));
        }

        requestModel.setNormalName( specid.getText().toString());

        requestModel.setPayMethod( Integer.valueOf(payMethod.getText().toString()) );
        requestModel.setProductid(Long.valueOf( productid.getTag().toString() ));
        requestModel.setProductName( productid.getText().toString() );
        requestModel.setProductImage( productImage.getTag().toString());
        requestModel.setUuType(uutype);
        requestModel.setVersion(version.getText().toString());

        long runTimeLong=0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "HH:mm:ss");
        try {
            //Date runTime = simpleDateFormat.parse(time.getText().toString());

//            Calendar calendar = Calendar.getInstance();
//            calendar.set( calendar.get(Calendar.YEAR) ,
//                    calendar.get(Calendar.MONTH) ,
//                    calendar.get( Calendar.DAY_OF_MONTH ),
//                    runTime.getHours(),
//                    runTime.getMinutes(),
//                    runTime.getSeconds()
//                    );

            Date today = new Date();

            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String runTimeStr = simpleDateFormat1.format(today) + " " + time.getText().toString() ;
            SimpleDateFormat simpleDateFormat2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date runTime = simpleDateFormat2.parse( runTimeStr );

            requestModel.setRunTime( runTimeStr );

            Date run = new Date( today.getYear() , today.getMonth(),
                    today.getDate() , runTime.getHours() , runTime.getMinutes(), runTime.getSeconds() );

            runTimeLong = run.getTime();

            if( today.compareTo( run ) >=0  ){
                Toast.makeText(this,"闹钟时间必须大于当前时间", Toast.LENGTH_LONG).show();
                return;
            }
        }catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
            return;
        }

        PreferenceHelper.writeString(this, Variable.prefName, Variable.prefKey , new Gson().toJson(requestModel));

        Intent intent = new Intent();
        intent.setClass(this , TryService.class);
        pendingIntent = PendingIntent.getService(getApplicationContext() , 3883 , intent , PendingIntent.FLAG_UPDATE_CURRENT);

//        Intent receiveIntent = new Intent();
//        receiveIntent.setAction("com.jxd.olartifact.try");
//        receiveIntent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
//        pendingIntent = PendingIntent.getBroadcast( getApplicationContext()  , 0 ,receiveIntent , PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.cancel( pendingIntent );

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            alarmManager.set(AlarmManager.RTC_WAKEUP , runTimeLong , pendingIntent);
        }else if(Build.VERSION.SDK_INT <Build.VERSION_CODES.M) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, runTimeLong, pendingIntent);
        }else {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP , runTimeLong , pendingIntent);
        }
        Toast.makeText(this,"定时触发已经设置ok",Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.save)
    public void save(View v){

//        Intent intent =new Intent();
//        intent.setAction("com.jxd.app2.test");
//        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
//        this.sendBroadcast( intent );

        savePref();
    }

    void savePref(){
        RequestModel mode = new RequestModel();
        mode.setPayPassword(null);
        mode.setPledgeMethod(null);
        mode.setAppkey( appkey.getText().toString());
        mode.setVersion( version.getText().toString() );
        mode.setUuType( uutype );
        mode.setProductid( Long.valueOf( productid.getTag().toString() ) );
        mode.setProductName( productid.getText().toString() );
        mode.setProductImage( productImage.getTag().toString() );
        mode.setPayMethod( Integer.valueOf( payMethod.getText().toString() ));
        mode.setAppSecret( appsecret.getText().toString());

        Integer pledgeMethod = rdb_jk_2.isChecked() ? 2 : rdb_yuer_3.isChecked()? 3: null;
        mode.setPledgeMethod(  pledgeMethod );

        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateStr = simpleDateFormat2.format(currentDate);

        //SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        try {
            String currentDateTimeStr = currentDateStr + " " + time.getText().toString();
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date t = simpleDateFormat3.parse( currentDateTimeStr );
            mode.setRunTime( currentDateTimeStr );
        }catch (Exception ex ){
            Toast.makeText(this,"无法解析运行时间",Toast.LENGTH_LONG).show();
            return;
        }

        mode.setMemberid( Long.valueOf( userid.getText().toString() ));
        mode.setAddressid( Integer.valueOf( addressid.getTag().toString() ) );
        mode.setAddress(addressid.getText().toString());
        mode.setMemo(memo);
        mode.setNum( Integer.valueOf( num.getText().toString() ));
        if(specid.getTag()==null || specid.getTag().toString().length()<1){
            mode.setNormalId(null);
        }else {
            mode.setNormalId(Integer.valueOf(specid.getTag().toString()));
        }

        mode.setNormalName( specid.getText().toString() );

        PreferenceHelper.writeString(this , Variable.prefName , Variable.prefKey ,  new Gson().toJson(mode));
        Toast.makeText(this, "save config ok",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.gotoJob)
    public void gotoJob(View v){
        Intent intent =new Intent();
        intent.setClass(this , JobActivity.class);
        this.startActivity(intent);
    }

    @OnClick(R.id.selectSpecif)
    public void selectSpecification(View v){
        Long uid = 0L;
        try {
            uid=Long.parseLong(userid.getText().toString());
        }catch (Exception ex){
            Toast.makeText(MainActivity.this, "请输入正确的用户Id",Toast.LENGTH_LONG).show();
            return;
        }
        Long pid=0L;
        try {
            pid=Long.parseLong(productid.getTag().toString());
        }catch (Exception ex){
            Toast.makeText(MainActivity.this, "请输入正确的商品Id",Toast.LENGTH_LONG).show();
            return;
        }

        Variable.version = version.getText().toString();
        Variable.appKey = appkey.getText().toString();
        Variable.appSecret = appsecret.getText().toString();

        Intent intent =new Intent(this,SpecifacationActivity.class);
        intent.putExtra("userid", uid );
        intent.putExtra("productid", pid);
        intent.putExtra("uutype", uutype);
        //intent.putExtra("speliststr", );
        startActivityForResult(intent ,101);
    }

    @OnClick(R.id.selectAddress)
    public void selectAddress(View v){
        Long uid = 0L;
        try {
            uid=Long.parseLong(userid.getText().toString());
        }catch (Exception ex){
            Toast.makeText(MainActivity.this, "请输入正确的用户Id",Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent =new Intent(this,AddressListActivity.class);
        intent.putExtra("userid", uid );
        startActivityForResult(intent ,102);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( resultCode == RESULT_OK && requestCode ==100 ){
            productid.setText(  valueOf( data.getStringExtra("productname")) );
            productid.setTag( data.getLongExtra("productid",0) );
            productImage.setTag(data.getStringExtra("productimage"));
            productImage.setImageURI(data.getStringExtra("productimage"));
            specid.setText("");
            specid.setTag(null);
        }else if(resultCode==RESULT_OK && requestCode== 101){
            specid.setText( data.getStringExtra("spname") );
            specid.setTag( data.getStringExtra("spid") );
        }else if(resultCode==RESULT_OK && requestCode== 102){
            addressid.setText( data.getStringExtra("address") );
            addressid.setTag( data.getIntExtra("addressid" , 0) );
        }
    }

    @OnClick(R.id.selectproduct)
    public   void selectProductId(View v ){
        Long uid = 0L;
        try {
            uid=Long.parseLong(userid.getText().toString());
        }catch (Exception ex){
            Toast.makeText(MainActivity.this, "请输入正确的用户Id",Toast.LENGTH_LONG).show();
            return;
        }

        Variable.version = version.getText().toString();
        Variable.appKey = appkey.getText().toString();
        Variable.appSecret = appsecret.getText().toString();

        Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
        intent.putExtra("userid", uid );
        this.startActivityForResult(intent , 100);
    }

//    @OnCheckedChanged({R.id.pledgeMethod_yue_3 , R.id.pledgeMethod_xiaojinku_2})
//    public void checkMethod(View v ) {
//        RadioButton r = (RadioButton) v;
//        r.setChecked(!r.isChecked());
//    }


}
