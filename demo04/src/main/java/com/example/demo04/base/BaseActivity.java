package com.example.demo04.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo04.contract.IContarct;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IContarct.IView {
public P mPresenter;
public EventBus eventBus;
private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getLayoutId()!=0){
            setContentView(getLayoutId());
            bind = ButterKnife.bind(this);
            eventBus = EventBus.getDefault();
            initViews();
            mPresenter = getPresenter();
            if (mPresenter != null) {
                mPresenter.onAttch(this);
                startCoding();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDeAttvh();
        mPresenter = null;
        if(eventBus.isRegistered(this)){
            eventBus.unregister(this);
        }
        if(bind!=null){
            bind.unbind();
        }
    }
    public void registerEventbus(){
        eventBus.register(this);
    }

    protected abstract void startCoding();

    protected abstract P getPresenter();

    protected abstract void initViews();

    protected abstract int getLayoutId();
}
