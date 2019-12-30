package com.bawei.bailang20191209.base;

import com.bawei.bailang20191209.cotrate.ICotrate;

import java.lang.ref.WeakReference;

public abstract class BasePersenter <V extends ICotrate.IView> implements ICotrate.IPersenter {
    private WeakReference<V> weakReference;
    public BasePersenter(){
        initModech();
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
    public V getViews(){
       return weakReference.get();
    }


    protected abstract void initModech();
}
