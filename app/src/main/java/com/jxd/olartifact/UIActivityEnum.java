package com.jxd.olartifact;

/**
 * Created by jinxiangdong on 2017/8/5.
 */

public enum UIActivityEnum {

    None(0,""),
    SplashUI(1,"com.olquanapp.ttds.android.ui.SplashActivity"),
    UpdateUI(2,"com.umeng.update.UpdateDialogActivity"),
    MainUI( 3 , "com.olquanapp.ttds.android.ui.MainActivity"),
    ColectionUI( 4,"com.olquanapp.ttds.android.ui.mine.CollectionActivity"),
    TrailUI(5,"com.olquanapp.ttds.android.ui.index.IndexOnTrialActivity"),
    ProductDetailUI(6,"com.olquanapp.ttds.android.ui.product.ProductDetailActivity");

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    UIActivityEnum(int code , String name){
        this.code = code;
        this.name=name;
    }

    public  static UIActivityEnum getByName(String name){
        for (UIActivityEnum c : UIActivityEnum.values()) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }


}
