package com.example.base;

import android.widget.BaseAdapter;

public abstract class BasePresenter<V extends BaseAdapter> {
    public V v;
    public void attach(V v){
        this.v=v;

    }

    public void unattach(){
        if(v!=null){
            v=null;
        }
    }

}
