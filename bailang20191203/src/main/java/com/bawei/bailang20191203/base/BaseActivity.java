package com.bawei.bailang20191203.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.bailang20191203.contart.MyContart;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements MyContart.IView {
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(layoutId()!=0){
            setContentView(layoutId());
            initView();
            mPresenter = getPersenter();
            mPresenter.onAttchView(this);
            startPersenter();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDreAttchView();
        }
    }

    protected abstract void startPersenter();

    protected abstract P getPersenter();

    protected abstract void initView();

    protected abstract int layoutId();
}
