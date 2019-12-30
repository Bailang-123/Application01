package com.example.project.fragmet;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project.R;
import com.example.project.base.BaseFragment;
import com.example.project.base.BasePersenter;
import com.example.project.presenter.MyPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends BaseFragment {

    @Override
    protected void initData() {

    }

    @Override
    protected BasePersenter getPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_order;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
}
