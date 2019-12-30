package com.bawei.bailang20191209.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.bailang20191209.cotrate.ICotrate;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseActivity <P extends BasePersenter> extends AppCompatActivity implements ICotrate.IView {
    public P mpresenter;
    private EventBus eventBus;

    public void eventbusInfo(){
        eventBus.register(this);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(layoutId()!=0){
            setContentView(layoutId());
            initView();
            mpresenter = getPersenter();
            mpresenter.onAttchView(this);
            startComprty();
        }
    }

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpresenter != null) {
            mpresenter.onDreAttchView();
        }
        if (eventBus != null) {
            eventBus.unregister(this);
        }
    }

    protected abstract void startComprty();

    protected abstract P getPersenter();

    protected abstract int layoutId();
}
