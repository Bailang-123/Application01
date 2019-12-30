package com.bawei.zhuoye01.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.zhuoye01.contart.MyContart;

public abstract class BaseActivity <P extends BasePersenter> extends AppCompatActivity implements MyContart.IView {
    private P mpersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(LayoutId()!=0){
            setContentView(LayoutId());
            initView();
            mpersenter = getPesenter();
            mpersenter.OnAttchView(this);
            startEonder();
        }
    }

    protected abstract void startEonder();

    protected abstract P getPesenter();

    protected abstract void initView();

    protected abstract int LayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpersenter.OnDreachAttchView();
    }
}
