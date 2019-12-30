package com.example.demo03.base;

import com.example.demo03.contrat.MyContart;

import java.lang.ref.WeakReference;

public abstract class BasePersneter<V extends MyContart.IView> implements MyContart.IPersenter {
    private  WeakReference<V> weakReference;
    public BasePersneter(){
        initModel();
    }
    public void onAttchView(V view){
        weakReference = new WeakReference<>(view);
    }
    public void onDreAttchView(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    public V getView(){
        return weakReference.get();
    }

    protected abstract void initModel();
}
