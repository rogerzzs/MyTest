package com.example.zhangzhongshuai.mytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zhangzhongshuai on 2017/9/5.
 */

public class TrueMainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);

        TextView content = new TextView(this);
        content.setText("I am Source Apk");
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

            }
        });
        setContentView(content);

        Log.i("demo", "app:" + getApplicationContext());
    }
}
