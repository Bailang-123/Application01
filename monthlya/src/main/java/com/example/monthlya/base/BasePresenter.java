package com.example.monthlya.base;

import com.example.monthlya.contrat.IContrat;

import java.lang.ref.WeakReference;

public abstract class BasePresenter <V extends IContrat.IView> implements IContrat.IPresenter {
    private WeakReference<V> weakReference;
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
