package com.jxd.olartifact;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */

public class AddressAdapter extends BaseQuickAdapter<Address,BaseViewHolder> {
    public AddressAdapter(@Nullable List<Address> data) {
        super( R.layout.layout_address_item , data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Address item) {
        helper.setText(R.id.tvname , item.getName());
        helper.setText(R.id.tvphone ,item.getMobile());
        helper.setText(R.id.tvaddress, item.getAddress());
    }
}
