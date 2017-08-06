package com.jxd.olartifact;

import java.io.Serializable;

/**
 * Created by jinxiangdong on 2017/8/6.
 */

public class ResultDO<T> implements Serializable {
    private static final long serialVersionUID = -1467576157657126613L;
    private int code;
    private String message;
    private boolean ok;
    private T result;


    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getResult() {
        return this.result;
    }

    public boolean isOk() {
        return this.ok;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setOk(boolean paramBoolean) {
        this.ok = paramBoolean;
    }

    public void setResult(T paramT) {
        this.result = paramT;
    }
}
