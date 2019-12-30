package com.example.demo03.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo03.contrat.MyContart;

public abstract class BaseActivity <P extends BasePersneter> extends AppCompatActivity implements MyContart.IView{
    public P mPersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(layoutId()!=0){
            setContentView(layoutId());
            initView();
            mPersenter = getPersenter();
            mPersenter.onAttchView(this);
            startPersenter();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPersenter.onDreAttchView();
    }

    protected abstract void startPersenter();

    protected abstract P getPersenter();

    protected abstract void initView();

    protected abstract int layoutId();
}
