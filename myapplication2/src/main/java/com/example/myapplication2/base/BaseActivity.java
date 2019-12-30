package com.example.myapplication2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.contart.Contarte;

import java.lang.ref.WeakReference;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contarte.MyView {
    public P mpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(layoutId()!=0){
            setContentView(layoutId());
            initView();
            mpresenter = getPresenter();
            mpresenter.onAttchView(this);
            startPresenter();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpresenter.onDreAttchView();
    }

    protected abstract void startPresenter();

    protected abstract P getPresenter();

    protected abstract void initView();

    protected abstract int layoutId();
}
