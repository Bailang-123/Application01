package com.bawei.bailang.base;

import com.bawei.bailang.contract.MyContract;

import java.lang.ref.WeakReference;

public abstract class BasePersenter <V extends MyContract.IView> implements MyContract.IPersenter {
    private WeakReference<V> weakReference;
    public BasePersenter(){
        initData();
    }
    public void onAttchView(V view){
        weakReference = new WeakReference<>(view);
    }
    public void onDraAttchView(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }
    public V getView(){
       return weakReference.get();
    }

    protected abstract void initData();
}
