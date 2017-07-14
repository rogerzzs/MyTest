package com.example.zhangzhongshuai.mytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * Created by zhangzhongshuai on 2017/7/12.
 */

public class SplashActivity extends Activity {
    private ImageView mSplashImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSplashImage = (ImageView)findViewById(R.id.splashimage);
        mSplashImage.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent toMain = new Intent();
                toMain.setClass(SplashActivity.this,MainActivity.class);
                startActivity(toMain);
                finish();
            }
        },3000);
    }
}
