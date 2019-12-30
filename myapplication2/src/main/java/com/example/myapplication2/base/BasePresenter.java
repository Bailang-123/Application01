package com.example.myapplication2.base;

import com.example.myapplication2.contart.Contarte;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends Contarte.MyView> implements Contarte.MyPresenter {
    private WeakReference<V> weakReference;

    public BasePresenter() {
        initData();
    }

    public void onAttchView(V view){
        weakReference = new WeakReference<>(view);
    }
    public void onDreAttchView(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference= null;
        }
    }
    public V getView(){
        return weakReference.get();
    }


    protected abstract void initData();
}
