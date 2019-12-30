package com.bawei.bailang20191203.base;

import com.bawei.bailang20191203.contart.MyContart;

import java.lang.ref.WeakReference;

public abstract class BasePresenter <V extends MyContart.IView> implements MyContart.IPresenter {
    public WeakReference<V> weakReference;

    public BasePresenter(){
        initData();
    }

    public void onAttchView(V view){
        weakReference = new WeakReference<>(view);
    }

    public void onDreAttchView(){
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
