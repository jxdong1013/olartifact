package com.jxd.olartifact;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2017/8/17.
 */

public class NormsesBean extends AbstractExpandableItem<Object> implements MultiItemEntity {
    private boolean isSelete;
    private String key;
    private String keyId;
    private String value;
    private String valueId;

    public boolean isSelete() {
        return isSelete;
    }

    public void setSelete(boolean selete) {
        isSelete = selete;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    @Override
    public int getItemType() {
        return Variable.SPECI_ITEM_TYPE_TWO;
    }

    @Override
    public int getLevel() {
        return 1;
    }
}
