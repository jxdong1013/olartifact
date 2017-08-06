package com.jxd.olartifact;

import android.os.Build;
import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jinxiangdong on 2017/8/6.
 */

public class SignInterceptor  implements Interceptor {
    public Response intercept(Interceptor.Chain paramChain) throws IOException {
        Object localObject = paramChain.request();
        if ((((Request) localObject).body() != null) && (((Request) localObject).header("Content-Encoding") == null)) {
            String str2 = StringUtils.getRandomString(8);
            String str1 = String.valueOf(System.currentTimeMillis() / 1000L);
            Log.i("request", ((Request) localObject).url().encodedPath());
            HttpUrl localHttpUrl = ((Request) localObject).url().newBuilder()
                    .addQueryParameter("platform", "android")
                    .addQueryParameter("version", Variable.version )
                    .addQueryParameter("model", Build.MODEL)
                    .addQueryParameter("os_version", Build.VERSION.RELEASE).build();
            localObject = paramChain.proceed(((Request) localObject).newBuilder().
                    url(localHttpUrl).header("App-Key", Variable.appKey ).
                    header("Nonce", str2).
                    header("Timestamp", str1).
                    addHeader("Signature", sign(str2, str1)).build());
            ((Response) localObject).newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 2419200).removeHeader("nyn").build();
        } else {
            localObject = paramChain.proceed((Request) localObject);
        }
        return (Response) localObject;
    }

    private  String sign( String paramString1 , String paramString2 ){
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Variable.appSecret ).append(paramString1).append(paramString2);
        return EncryptUtils.sha1( localStringBuilder.toString() );
    }

}
