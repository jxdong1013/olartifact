package com.jxd.olartifact;

import android.support.annotation.Nullable;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionEntity;

import java.util.List;


/**
 * Created by Administrator on 2017/8/16.
 */
public class SpecificationAdapter extends BaseSectionQuickAdapter<MySpecificationSection , BaseViewHolder> {
//extends BaseMultiItemQuickAdapter<MultiItemEntity ,BaseViewHolder> {


    public SpecificationAdapter(List<MySpecificationSection> data) {
        super(R.layout.layout_specifacation_item, R.layout.layout_specification_one_item, data);
    }


    @Override
    protected void convertHead(BaseViewHolder helper, MySpecificationSection item) {
        helper.setText(R.id.spec_item_parent, item.header );

    }

    @Override
    protected void convert(BaseViewHolder helper, MySpecificationSection item) {
        helper.setText(R.id.spec_item_name, item.t.getName());

        helper.setBackgroundRes( R.id.spec_item_name ,  item.t.isSelected() ? R.drawable.selected_spec_style : R.drawable.unselected_spec_style );
    }

}
