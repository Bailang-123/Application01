package com.bawei.bailang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bawei.bailang.base.BaseActivity;
import com.bawei.bailang.base.BasePersenter;
import com.bawei.bailang.persenter.MyPersenter;

public class MainActivity extends BaseActivity {

    private WebView webView;

    @Override
    protected void startView() {

    }

    @Override
    protected BasePersenter getPersenter() {
        return new MyPersenter();
    }

    @Override
    protected void initView() {
        webView = findViewById(R.id.web_view01);
        webView.loadUrl("http://172.17.8.100/small/commodity/v1/bannerShow");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String url) {

    }

    @Override
    public void onError(String error) {

    }
}
