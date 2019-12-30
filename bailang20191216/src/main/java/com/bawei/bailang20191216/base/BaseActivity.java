package com.bawei.bailang20191216.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.bailang20191216.contrat.MyContrat;

public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements MyContrat.IView {
public P mpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(layoutId()!=0){
            setContentView(layoutId());
            initView();
            mpresenter = getPresenter();
            mpresenter.onAttchView(this);
            startEormay();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpresenter.onDraAttchView();
    }

    protected abstract void startEormay();

    protected abstract P getPresenter();

    protected abstract void initView();

    protected abstract int layoutId();
}
