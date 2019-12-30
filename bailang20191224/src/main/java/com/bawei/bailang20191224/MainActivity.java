package com.bawei.bailang20191224;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bawei.bailang20191224.base.BaseActivity;
import com.bawei.bailang20191224.base.BasePresenter;
import com.bawei.bailang20191224.presenterI.Presenter;

public class MainActivity extends BaseActivity {

    @Override
    protected void startEromy() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void OnSuccess(Object o) {

    }

    @Override
    public void OnError(String error) {

    }
}
