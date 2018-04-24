package com.example.zhangzhongshuai.mytest;

import android.app.Application;
import android.util.Log;


/**
 * Created by zhangzhongshuai on 2017/9/4.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("demo", "source apk onCreate:" + this);
        new BuilderTest.BuilderTestBuild().setAge("2").setName("4").setSex("1").build();
    }
}
