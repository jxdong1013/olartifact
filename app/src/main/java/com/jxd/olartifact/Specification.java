package com.jxd.olartifact;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */

public class Specification {
    private String id;
    private String name;
    private boolean isSelected;
    private List<Specification> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Specification> getItems() {
        return items;
    }

    public void setItems(List<Specification> items) {
        this.items = items;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
