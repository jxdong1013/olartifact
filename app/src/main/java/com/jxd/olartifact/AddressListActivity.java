package com.jxd.olartifact;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.jxd.olartifact.R.id.empty_text;
import static com.jxd.olartifact.R.id.userId;

public class AddressListActivity extends AppCompatActivity implements View.OnClickListener ,BaseQuickAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    ArrayList<Address> data= null;
    AddressAdapter addressAdapter;
    View emptyView;

    Long memberId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        data = new ArrayList<>();
        addressAdapter = new AddressAdapter(data);
        addressAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter( addressAdapter );
        emptyView = LayoutInflater.from(this).inflate(R.layout.layout_empty,null);
        addressAdapter.setEmptyView( emptyView);
        addressAdapter.getEmptyView().findViewById(R.id.empty_text).setOnClickListener(this);
        ((TextView)emptyView.findViewById(R.id.empty_text)).setText("没有收货地址");

    }

    @Override
    public void onRefresh() {
        data.clear();
        addressAdapter.setNewData(data);
        getAddressList();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if( getIntent().getExtras() !=null && getIntent().getExtras().containsKey("userid")){
            memberId= getIntent().getExtras().getLong("userid",0);
        }

        getAddressList();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.empty_text){
            data.clear();
            addressAdapter.setNewData(data);
            getAddressList();
        }
    }

//    @OnClick(R.id.btnOk)
//    public void ok(View v){
//        Intent intent=getIntent();
//        intent.putExtra("addressid", data.get(position).getId());
//        this.setResult(RESULT_OK,intent);
//        this.finish();
//    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent=getIntent();
        intent.putExtra("addressid", data.get(position).getId());
        intent.putExtra("address",data.get(position).getAddress());
        this.setResult(RESULT_OK,intent);
        this.finish();
    }

    protected void getAddressList() {
        if (memberId < 1) {
            Toast.makeText(this, "用户id值错误", Toast.LENGTH_LONG).show();
            return;
        }
        Call<ResultDO<List<Address>>> call = HttpClient.getHttpAdapter().memberAddresses(memberId );
        call.enqueue(new Callback<ResultDO<List<Address>>>() {
            @Override
            public void onResponse(Call<ResultDO<List<Address>>> call, Response<ResultDO<List<Address>>> response) {
                swipeRefreshLayout.setRefreshing(false);
                if( response.code() !=200 ){
                    Toast.makeText(AddressListActivity.this,"error "+ response.message() ,Toast.LENGTH_LONG).show();
                    return;
                }
                if( response.body().getCode() !=0){
                    Toast.makeText(AddressListActivity.this, response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    return;
                }

                addressAdapter.addData( response.body().getResult() );
            }

            @Override
            public void onFailure(Call<ResultDO<List<Address>>> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(AddressListActivity.this, "error",Toast.LENGTH_LONG).show();
            }
        });
    }
}
