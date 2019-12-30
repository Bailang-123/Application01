package com.example.weekly.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weekly.contrat.IContrat;

public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements IContrat.IView {
    public P mpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(LayoutId()!=0){
            setContentView(LayoutId());
            initView();
            mpresenter = getPresenter();
            mpresenter.onAttchView(this);
            startComptry();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpresenter != null) {
            mpresenter.onDraAttchView();
        }
    }

    protected abstract void startComptry();

    protected abstract void initView();

    protected abstract P getPresenter();

    protected abstract int LayoutId();
}
