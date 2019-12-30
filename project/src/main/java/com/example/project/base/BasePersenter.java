package com.example.project.base;

import com.example.project.contrat.IContrat;

import java.lang.ref.WeakReference;

public abstract class BasePersenter <V extends IContrat.IView> implements IContrat.IPersenter {
    private WeakReference<V> weakReference;
    public BasePersenter(){
        initMata();
    }

    public void onAttchView(V view){
        weakReference = new WeakReference<>(view);
    }
    public void onDreaAttchView(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }
    public V getview(){
        return weakReference.get();
    }

    protected abstract void initMata();
}
