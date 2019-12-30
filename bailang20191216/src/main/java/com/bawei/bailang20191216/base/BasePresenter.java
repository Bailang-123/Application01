package com.bawei.bailang20191216.base;

import com.bawei.bailang20191216.contrat.MyContrat;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends MyContrat.IView> implements MyContrat.IPresenter {
    private WeakReference<V> weakReference;

    public BasePresenter() {
        initData();
    }

    protected abstract void initData();

    public void onAttchView(V view) {
        weakReference = new WeakReference<>(view);
    }

    public void onDraAttchView() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public V getView() {
        return weakReference.get();
    }
}
