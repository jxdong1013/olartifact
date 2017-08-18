package com.jxd.olartifact;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by Administrator on 2017/8/17.
 */

public class MySpecificationSection extends SectionEntity<Specification> {
    public MySpecificationSection(boolean isHeader, String header) {
        super(isHeader, header);
    }
    public MySpecificationSection(Specification specification) {
        super(specification);
    }


}
