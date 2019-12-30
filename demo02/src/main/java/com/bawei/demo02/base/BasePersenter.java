package com.bawei.demo02.base;

import com.bawei.demo02.contract.MyContract;

import java.lang.ref.WeakReference;

public abstract class BasePersenter <V extends MyContract.IView> implements MyContract.IPresenter {
    private WeakReference<V> mWeakV;

    public BasePersenter() {
        initModel();
    }

    public void onAttchView(V v) {
        mWeakV = new WeakReference<>(v);
    }

    public void onDeAttchView() {
        if (mWeakV != null) {
            mWeakV.clear();
            mWeakV = null;
        }
    }

    protected V getView() {
        return mWeakV.get();
    }

    abstract protected void initModel();
}
