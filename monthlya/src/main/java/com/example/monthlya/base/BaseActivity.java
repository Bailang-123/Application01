package com.example.monthlya.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.monthlya.contrat.IContrat;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IContrat.IView {
    public P mpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(layoutId()!=0){
            setContentView(layoutId());
            initView();
            mpresenter = getpresenter();
            mpresenter.onAttchView(this);
            startEromty();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpresenter.onDreAttchView();
    }

    protected abstract void startEromty();

    protected abstract void initView();

    protected abstract P getpresenter();

    protected abstract int layoutId();
}
