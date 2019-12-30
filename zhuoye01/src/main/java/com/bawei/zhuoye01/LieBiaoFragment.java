package com.bawei.zhuoye01;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.zhuoye01.base.BaseFragment;
import com.bawei.zhuoye01.base.BasePersenter;
import com.bawei.zhuoye01.persenter.MyPersenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class LieBiaoFragment extends BaseFragment {

    @Override
    protected void initData() {

    }

    @Override
    protected BasePersenter getPersenter() {
        return new MyPersenter();
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_lie_biao;
    }

    @Override
    public void OnSuccess(String url) {

    }

    @Override
    public void OnError(String error) {

    }
}
