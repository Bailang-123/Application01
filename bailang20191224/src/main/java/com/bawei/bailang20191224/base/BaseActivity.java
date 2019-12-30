package com.bawei.bailang20191224.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.bailang20191224.contart.MyContarte;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements MyContarte.MyView {
    public P mpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(layoutId()!=0){
            setContentView(layoutId());
            initView();
            mpresenter = getPresenter();
            mpresenter.onDraActtchView();
            startEromy();
        }
    }

    protected abstract void startEromy();

    protected abstract P getPresenter();

    protected abstract void initView();

    protected abstract int layoutId();
}
