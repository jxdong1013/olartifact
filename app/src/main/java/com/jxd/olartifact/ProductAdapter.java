package com.jxd.olartifact;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */

public class ProductAdapter extends BaseQuickAdapter<Collect , BaseViewHolder> {

    public ProductAdapter(@Nullable List<Collect> data) {
        super( R.layout.layout_item_product_item , data);
    }

    public ProductAdapter(@LayoutRes int layoutResId, @Nullable List<Collect> data) {

        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Collect item) {
        SimpleDraweeView simpleDraweeView = helper.getView(R.id.item_productimage);
        simpleDraweeView.setImageURI( item.getImage() );
        helper.setText(R.id.item_productname , item.getProductName());
        helper.setText(R.id.item_productprice , "价格:"+ item.getPrice()+" 库存:"+item.getScore());
    }
}
