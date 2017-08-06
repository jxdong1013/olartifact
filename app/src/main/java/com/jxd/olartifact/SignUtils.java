package com.jxd.olartifact;

/**
 * Created by jinxiangdong on 2017/8/6.
 */

public class SignUtils {
    private static String sign(String paramString1, String paramString2)
    {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("wBH4YJUYIa6a").append(paramString1).append(paramString2);
        return EncryptUtils.sha1(localStringBuilder.toString());
    }

}
