package com.bawei.demo02.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.demo02.contract.MyContract;

public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity implements MyContract.IView {
    public P mPresenter;
//    protected Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
            //得先加载完试图模版过后才能绑定
//            unbinder = ButterKnife.bind(this);
            initViews();
            mPresenter = getPresenter();
            mPresenter.onAttchView(this);
            startEncoding();
        }
    }

    abstract protected P getPresenter();

    abstract protected int getLayoutId();

    abstract protected void initViews();

    abstract protected void startEncoding();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDeAttchView();
        }
//        if (unbinder != null) {
//            unbinder.unbind();
//        }
    }
}
