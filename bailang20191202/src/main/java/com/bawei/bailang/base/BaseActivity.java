package com.bawei.bailang.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.bailang.contract.MyContract;

public abstract class BaseActivity <P extends BasePersenter> extends AppCompatActivity implements MyContract.IView {
    public P mpersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(layoutId()!=0){
            setContentView(layoutId());
            initView();
            mpersenter = getPersenter();
            mpersenter.onAttchView(this);
            startView();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpersenter.onDraAttchView();
    }

    protected abstract void startView();

    protected abstract P getPersenter();

    protected abstract void initView();

    protected abstract int layoutId();
}
