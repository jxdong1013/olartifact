package com.jxd.olartifact;


import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity implements View.OnClickListener ,
        BaseQuickAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener{
    Long userId;
    ProductAdapter productAdapter;
    List<Collect> datas;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    View emptyView;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);

        mHandler = new Handler(getMainLooper());

        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        datas = new ArrayList<>();
        productAdapter = new ProductAdapter(datas);
        recyclerView.setAdapter( productAdapter );

        emptyView = LayoutInflater.from(this).inflate(R.layout.layout_empty,null);
        productAdapter.setEmptyView( emptyView);
        productAdapter.getEmptyView().findViewById(R.id.empty_text).setOnClickListener(this);

        productAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.empty_text){
            datas.clear();
            productAdapter.setNewData(datas);
            getProductIds();
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent=getIntent();
        intent.putExtra("productid", datas.get(position).getProductId());
        intent.putExtra("productname",datas.get(position).getProductName());
        intent.putExtra("productimage",datas.get(position).getImage());
        this.setResult(RESULT_OK,intent);
        this.finish();
    }

    @Override
    public void onRefresh() {
        datas.clear();
        productAdapter.setNewData(datas);
        getProductIds();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if( getIntent().getExtras() !=null && getIntent().getExtras().containsKey("userid")){
            userId= getIntent().getExtras().getLong("userid",0);
        }

        getProductIds();
    }

    void getProductIds() {
        if( userId <1){
            Toast.makeText(this,"用户id值错误",Toast.LENGTH_LONG).show();
            return;
        }

        Call<ResultDO<List<Collect>>> call = HttpClient.getHttpAdapter().collects( userId , 1);//1:代表收藏的商品
        call.enqueue(new Callback<ResultDO<List<Collect>>>() {
            @Override
            public void onResponse(Call<ResultDO<List<Collect>>> call, Response<ResultDO<List<Collect>>> response) {
                swipeRefreshLayout.setRefreshing(false);
                if( response.code() !=200 ){
                    Toast.makeText(ProductListActivity.this,"error "+ response.message() ,Toast.LENGTH_LONG).show();
                    return;
                }
                if( response.body().getCode() !=0){
                    Toast.makeText(ProductListActivity.this, response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    return;
                }

                productAdapter.addData( response.body().getResult() );
            }

            @Override
            public void onFailure(Call<ResultDO<List<Collect>>> call, Throwable t) {
                Toast.makeText(ProductListActivity.this, "error",Toast.LENGTH_LONG).show();
            }
        });

    }
}
