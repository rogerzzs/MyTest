package com.example.zhangzhongshuai.mytest;

import retrofit2.Retrofit;

/**
 * Created by zhangzhongshuai on 2017/7/12.
 */

public class RetrofitUtils {
    public static Retrofit getRetrofit(){
        return new Retrofit.Builder().baseUrl(ServerAPI.BASE_URL).build();
    }
}
