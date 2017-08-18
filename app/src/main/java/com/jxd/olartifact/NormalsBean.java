package com.jxd.olartifact;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */

public class NormalsBean  extends AbstractExpandableItem<Object> implements MultiItemEntity  {
    private String id;
    private String key;
    private List<NormsesBean> normses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<NormsesBean> getNormses() {
        return normses;
    }

    public void setNormses(List<NormsesBean> normses) {
        this.normses = normses;
    }

    @Override
    public int getItemType() {
        return Variable.SPECI_ITEM_TYPE_ONE;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
