package com.jxd.olartifact;

/**
 * Created by jinxiangdong on 2017/8/6.
 */

public class PayInfo {
    private String alipayString;
    private String appId;
    private String nonceStr;
    private String orderPayRecordNo;
    private String package_;
    private String partnerid;
    private PayInfo payInfo;
    private String paySign;
    private String prepayId;
    private String signType;
    private String timeStamp;
    private int type;

    public String getAlipayString() {
        return alipayString;
    }

    public void setAlipayString(String alipayString) {
        this.alipayString = alipayString;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getOrderPayRecordNo() {
        return orderPayRecordNo;
    }

    public void setOrderPayRecordNo(String orderPayRecordNo) {
        this.orderPayRecordNo = orderPayRecordNo;
    }

    public String getPackage_() {
        return package_;
    }

    public void setPackage_(String package_) {
        this.package_ = package_;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public PayInfo getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(PayInfo payInfo) {
        this.payInfo = payInfo;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
