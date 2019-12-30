package com.bawei.bailang201912130;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bawei.bailang201912130.base.BaseActivity;
import com.bawei.bailang201912130.base.BasePresenter;
import com.bawei.bailang201912130.presenter.IPresenter;

public class MainActivity extends BaseActivity {
    private TextView textView;

    @Override
    protected void startPresenter() {
        mpresenter.PresenterInfo("http://172.17.8.100/small/commodity/v1/bannerShow");
    }

    @Override
    protected BasePresenter getPresenter() {
        return new IPresenter();
    }

    @Override
    protected void initView() {
        textView = findViewById(R.id.text_view);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String url) {
        textView.setText(url);
    }

    @Override
    public void onError(String error) {

    }
}
