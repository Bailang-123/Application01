package com.example.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p=Ipresenter();
        if(p!=null){
        }
        setContentView(inilayout());

        iniview();

        inidata();
    }

    protected abstract void inidata();

    protected abstract void iniview();

    protected abstract int inilayout();
    protected abstract P Ipresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(p!=null){
            p.unattach();
            p=null;
        }
    }
}
