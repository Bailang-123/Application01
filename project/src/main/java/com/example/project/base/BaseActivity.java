package com.example.project.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.contrat.IContrat;

public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity implements IContrat.IView {
    public P mpersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId() != 0) {
            setContentView(layoutId());
            initView();
            mpersenter = getPersenter();
            mpersenter.onAttchView(this);
            startCompy();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpersenter != null) {
            mpersenter.onDreaAttchView();
        }
    }

    protected abstract void startCompy();

    protected abstract P getPersenter();

    protected abstract void initView();

    protected abstract int layoutId();
}
