package com.example.weekly.base;

import com.example.weekly.contrat.IContrat;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IContrat.IView> implements IContrat.IPresenter {
    private WeakReference<V> weakReference;
    public BasePresenter(){
        initData();
    }
    public void onAttchView(V veiw){
        weakReference = new WeakReference<>(veiw);
    }

    public void onDraAttchView(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public V getview(){
        return weakReference.get();
    }
    protected abstract void initData();
}
