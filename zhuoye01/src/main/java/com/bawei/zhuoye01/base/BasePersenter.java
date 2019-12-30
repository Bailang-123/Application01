package com.bawei.zhuoye01.base;

import com.bawei.zhuoye01.contart.MyContart;

import java.lang.ref.WeakReference;

public abstract class BasePersenter <V extends MyContart.IView> implements MyContart.IPersenter {
    public WeakReference<V> weakReference;
    public BasePersenter(){
    initDate();
    }
    public void OnAttchView(V view){
        weakReference = new WeakReference<>(view);
    }

    public void OnDreachAttchView(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }
    public V getVew(){
        return weakReference.get();
    }

    protected abstract void initDate();

}
