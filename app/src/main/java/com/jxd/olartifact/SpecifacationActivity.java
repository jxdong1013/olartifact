package com.jxd.olartifact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.jxd.olartifact.R.id.productId;
import static com.jxd.olartifact.R.id.recyclerView;
import static com.jxd.olartifact.R.id.userId;

public class SpecifacationActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemClickListener{
    Long userid;
    Long pid;
    int uutype;
    SpecificationAdapter specificationAdapter;
    //List<MultiItemEntity> data;
    List<MySpecificationSection> data;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.btnOk)
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specifacation);
        ButterKnife.bind(this);

        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position) {
                return specificationAdapter.getItemViewType(position) == Variable.SPECI_ITEM_TYPE_ONE ? 2:1;
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        data=new ArrayList<>();
        specificationAdapter =new SpecificationAdapter(data);
        recyclerView.setAdapter(specificationAdapter);
        specificationAdapter.expandAll();
        recyclerView.setItemAnimator( new DefaultItemAnimator());
        specificationAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        MySpecificationSection mySpecificationSection = data.get(position);

        for(MySpecificationSection item : data){
            if( item.header.equals( mySpecificationSection.header ) && item.isHeader ==false && item.t.getId() != mySpecificationSection.t.getId() ){
                item.t.setSelected(false);
            }
        }

        mySpecificationSection.t.setSelected( !mySpecificationSection.t.isSelected() );

        specificationAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();

        userid = getIntent().getExtras().getLong("userid");
        pid = getIntent().getExtras().getLong("productid");
        uutype = getIntent().getExtras().getInt("uutype");

        getSpeci();

    }

    protected void generateData(List<NormalsBean> list){
        data.clear();
        for(NormalsBean item : list){
            MySpecificationSection section = new MySpecificationSection(true , item.getKey());
            Specification specification=new Specification();
            specification.setId(item.getId());
            specification.setName(item.getKey());
            //section.t =specification;
            data.add(section);

            for(NormsesBean sub : item.getNormses()){
                specification=new Specification();
                specification.setId(sub.getValueId());
                specification.setName(sub.getValue());
                section =new MySpecificationSection( specification );
                section.header = item.getKey();
                data.add(section);
            }
        }
    }

    protected void getSpeci(){


        Call<ResultDO<Product>> call = HttpClient.getHttpAdapter().productDetail( pid , userid , uutype);
        call.enqueue(new Callback<ResultDO<Product>>() {
            @Override
            public void onResponse(Call<ResultDO<Product>> call, Response<ResultDO<Product>> response) {
                if( response.code() !=200 ){
                    Toast.makeText(SpecifacationActivity.this,"error "+ response.message() ,Toast.LENGTH_LONG).show();
                    return;
                }
                if( response.body().getCode() !=0){
                    Toast.makeText(SpecifacationActivity.this, response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    return;
                }

                 generateData( response.body().getResult().getNormals() );
                specificationAdapter.setNewData(  data );
                specificationAdapter.expandAll();
            }

            @Override
            public void onFailure(Call<ResultDO<Product>> call, Throwable t) {
                Toast.makeText(SpecifacationActivity.this, "error",Toast.LENGTH_LONG).show();
            }
        });
    }

    void getSpecification(){
        String valuesId = "";
        if(data==null|| data.size()<1) return;
        int secCount = 0;
        int facount = 0;
        for(MySpecificationSection section : data){
            if(section.isHeader){ secCount++; continue;}
            if(!section.t.isSelected()) continue;
            valuesId+=section.t.getId();
            valuesId+=",";
            facount++;
        }
        if( valuesId.isEmpty() ) {
            Toast.makeText(this,"请选择规格",Toast.LENGTH_LONG).show();
            return;
        }
        if( facount != secCount ){
            Toast.makeText(this,"请选择相应的规格",Toast.LENGTH_LONG).show();
            return;
        }

        valuesId = valuesId.substring(0, valuesId.length()-1);

        Call<ResultDO<ProductNormal>> call = HttpClient.getHttpAdapter().getNormal( pid  , userid , uutype , valuesId );
        call.enqueue(new Callback<ResultDO<ProductNormal>>() {
            @Override
            public void onResponse(Call<ResultDO<ProductNormal>> call, Response<ResultDO<ProductNormal>> response) {
                if( response.code() !=200 ){
                    Toast.makeText(SpecifacationActivity.this,"error "+ response.message() ,Toast.LENGTH_LONG).show();
                    return;
                }
                if( response.body().getCode() !=0){
                    Toast.makeText(SpecifacationActivity.this, response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent=getIntent();
                intent.putExtra("spname", response.body().getResult().getNormalStr());
                intent.putExtra("spid", String.valueOf( response.body().getResult().getId()));
                SpecifacationActivity.this.setResult(RESULT_OK, intent);
                SpecifacationActivity.this.finish();
            }

            @Override
            public void onFailure(Call<ResultDO<ProductNormal>> call, Throwable t) {
                Toast.makeText(SpecifacationActivity.this, "error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btnOk)
    public void ok(View v){
        getSpecification();
    }
}
