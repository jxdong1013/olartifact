package com.jxd.olartifact;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jinxiangdong on 2017/8/6.
 */

public class HttpClient {
    //public static String API_URL;
    public static String API_URL2 = "http://ol-mobile2.olquan.cn:80/";
    private static OkHttpClient client;
    private static HttpService httpService;
    private static Retrofit imAdapter;
    //static HttpLoggingInterceptor loggingInterceptor;
    //private static MemberService memberService;

//    static
//    {
//        API_URL = "http://ol-site.olquan.com/";
//        //loggingInterceptor = new HttpLoggingInterceptor();
//    }

    public static HttpService getHttpAdapter()
    {
        if (imAdapter == null)
        {
            //loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client = new OkHttpClient.Builder()
                    //.addInterceptor(loggingInterceptor)
                    .addInterceptor(new SignInterceptor()).build();
            imAdapter = new Retrofit.Builder()
                    .baseUrl(API_URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client).build();
        }
        httpService = (HttpService)imAdapter.create(HttpService.class);
        return httpService;
    }

}
