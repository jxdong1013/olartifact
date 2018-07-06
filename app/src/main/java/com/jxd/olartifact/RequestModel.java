package com.jxd.olartifact;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/7.
 */

public class RequestModel {
    private   Long productid;
    private String productName;
    private String productImage;
    private  Long memberid;
    private  Integer num;
    private  Integer addressid;
    private String address;
    private  Integer normalId;
    private String normalName;
    private  Integer payMethod;
    private  Integer uuType;
    private  String memo="memo";
    private  String version="version";
    private  String appkey="appkey";
    private String appSecret="appsecret";
    private String payPassword;
    private Integer pledgeMethod;
    private String runTime;


    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getNormalId() {
        return normalId;
    }

    public void setNormalId(Integer normalId) {
        this.normalId = normalId;
    }

    public String getNormalName() {
        return normalName;
    }

    public void setNormalName(String normalName) {
        this.normalName = normalName;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getUuType() {
        return uuType;
    }

    public void setUuType(Integer uuType) {
        this.uuType = uuType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public Integer getPledgeMethod() {
        return pledgeMethod;
    }

    public void setPledgeMethod(Integer pledgeMethod) {
        this.pledgeMethod = pledgeMethod;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
