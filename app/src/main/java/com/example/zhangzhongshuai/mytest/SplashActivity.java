package com.example.zhangzhongshuai.mytest;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by zhangzhongshuai on 2017/7/12.
 */
@RuntimePermissions
public class SplashActivity extends Activity {
    private ImageView mSplashImage;
    private Button button;
    private final int MY_PERMISSTION_REQUEST_READ_EXTERNAL_STORAGE = 10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        button = (Button) findViewById(R.id.buttonPanel);
        mSplashImage = (ImageView)findViewById(R.id.splashimage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashActivityPermissionsDispatcher.showStorageWithCheck(SplashActivity.this);
            }
        });
    }

    @NeedsPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
    void showStorage() {
        Toast.makeText(this, "权限已允许，do your work", Toast.LENGTH_SHORT).show();
    }

    @OnPermissionDenied(Manifest.permission.READ_EXTERNAL_STORAGE)
    void onStorageDenied() {
        Toast.makeText(this, "拒绝了权限请求", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.READ_EXTERNAL_STORAGE)
    void onStorageNeverAskAgain() {
        Toast.makeText(this, "在此引导用户去设置界面开启权限", Toast.LENGTH_SHORT).show();
    }

    @OnShowRationale(Manifest.permission.READ_EXTERNAL_STORAGE)
    void showRationaleForContact(PermissionRequest request) {
        Toast.makeText(this, "提示用户允许权限", Toast.LENGTH_SHORT).show();
        showRationaleDialog(R.string.fjkdfjfkjdkfkd, request);
    }

    private void showRationaleDialog(@StringRes int messageResId, final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .setCancelable(false)
                .setMessage(messageResId)
                .show();
    }

    private void checkPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                Toast.makeText(this,"你应该同意的",Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSTION_REQUEST_READ_EXTERNAL_STORAGE);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSTION_REQUEST_READ_EXTERNAL_STORAGE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(SplashActivity.this, requestCode, grantResults);
    }
}
