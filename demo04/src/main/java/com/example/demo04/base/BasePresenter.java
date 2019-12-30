package com.example.demo04.base;

import com.example.demo04.contract.IContarct;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IContarct.IView> implements IContarct.IPresenter {
    private WeakReference<V> weakReference;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void onAttch(V view) {
        weakReference = new WeakReference<>(view);
    }

    public void onDeAttvh() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public V getView() {
        return weakReference.get();
    }
}

