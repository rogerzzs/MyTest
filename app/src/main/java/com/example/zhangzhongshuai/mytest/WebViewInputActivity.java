package com.example.zhangzhongshuai.mytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangzhongshuai on 2017/10/17.
 */

public class WebViewInputActivity extends Activity {
    private EditText editText;
    private Button button;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinput);
        HashMap map = new HashMap();
        map.put("1", "a");
        map.put("1", "b");
        Log.w("zzs", "mapstirng : " + map.toString());
        editText = (EditText) findViewById(R.id.inputUrlEt);
        button = (Button) findViewById(R.id.loadBtn);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                url = editText.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(WebViewInputActivity.this, WebViewTestActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        EqualsTest test1 = new EqualsTest();
        EqualsTest test2 = new EqualsTest();
        test1.name = test2.name = 100;
        boolean isSame = test1.equals(test2);
    }
}
