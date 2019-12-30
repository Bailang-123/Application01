package com.bawei.bailang20191224.base;

import com.bawei.bailang20191224.contart.MyContarte;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends MyContarte.MyView> implements MyContarte.MyPresenter {
    private WeakReference<V> weakReference;
    public BasePresenter(){
        initData();
    }

    public void onActtchView(V view){
        weakReference = new WeakReference<>(view);
    }

    public void onDraActtchView(){
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
