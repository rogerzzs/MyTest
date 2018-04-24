package com.example.zhangzhongshuai.mytest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by zhangzhongshuai on 2017/10/17.
 */

public class WebViewTestActivity extends Activity {
    private WebView webView;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = (WebView) findViewById(R.id.webview);
        url = getIntent().getStringExtra("url");
        WebSettings setting = webView.getSettings();
        setting.setSupportZoom(true);
        setting.setBuiltInZoomControls(false);
        setting.setUseWideViewPort(false);

        setting.setJavaScriptEnabled(true);
        setting.setTextSize(WebSettings.TextSize.NORMAL);
        setting.setDomStorageEnabled(true);

        webView.setWebViewClient(new MyWebViewClient());

        webView.setWebChromeClient(new MyWebChromeClient());
        webView.loadUrl(url);
    }

    private final class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("http:") || url.startsWith("https:")) {
                view.loadUrl(url);
            }
            return true;
        }


        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
        }

        @Override
        public void onPageFinished(WebView view, String url) {
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }

    private final class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {

        }

    }
}
