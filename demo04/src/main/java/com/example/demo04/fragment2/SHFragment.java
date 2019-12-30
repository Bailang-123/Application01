package com.example.demo04.fragment2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo04.R;
import com.example.demo04.base.BaseFragment;
import com.example.demo04.base.BasePresenter;
import com.example.demo04.presenter.PresenterImpl;


/**
 * A simple {@link Fragment} subclass.
 */
public class SHFragment extends BaseFragment {


    @Override
    protected void startCompry() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_sh;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
}
