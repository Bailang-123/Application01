package com.example.project.fragmet;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.project.BannerBean;
import com.example.project.R;
import com.example.project.base.BaseFragment;
import com.example.project.base.BasePersenter;
import com.example.project.presenter.MyPresenter;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Friends_Fragment extends BaseFragment {

    private XBanner xBanner;
    private List<ImageView> list = new ArrayList<>();
    @Override
    protected void initData() {
    }

    @Override
    protected BasePersenter getPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView(View inflate) {
        xBanner = inflate.findViewById(R.id.xbanner_shouye);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_friends_;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof BannerBean){

        }
    }

    @Override
    public void onError(String error) {

    }
}
