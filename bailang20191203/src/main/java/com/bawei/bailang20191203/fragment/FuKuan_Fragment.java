package com.bawei.bailang20191203.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.bailang20191203.R;
import com.bawei.bailang20191203.base.BaseFragment;
import com.bawei.bailang20191203.base.BasePresenter;
import com.bawei.bailang20191203.persenter.MyPersneter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FuKuan_Fragment extends BaseFragment {


    @Override
    protected void initDatas() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new MyPersneter();
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_fu_kuan_;
    }

    @Override
    public void onSuccess(String url) {

    }

    @Override
    public void onError(String url) {

    }
}
