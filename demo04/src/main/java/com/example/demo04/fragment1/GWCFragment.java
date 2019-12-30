package com.example.demo04.fragment1;


import androidx.fragment.app.Fragment;

import android.view.View;

import com.example.demo04.R;
import com.example.demo04.base.BaseFragment;
import com.example.demo04.base.BasePresenter;
import com.example.demo04.presenter.PresenterImpl;


/**
 * A simple {@link Fragment} subclass.
 */
public class GWCFragment extends BaseFragment {

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
        return R.layout.fragment_gwc;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
}
