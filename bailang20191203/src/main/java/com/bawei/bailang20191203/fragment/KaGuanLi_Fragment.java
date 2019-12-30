package com.bawei.bailang20191203.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.bailang20191203.R;
import com.bawei.bailang20191203.adapter.MyAdapter;
import com.bawei.bailang20191203.base.BaseFragment;
import com.bawei.bailang20191203.base.BasePresenter;
import com.bawei.bailang20191203.bean.JsonBean;
import com.bawei.bailang20191203.persenter.MyPersneter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class KaGuanLi_Fragment extends BaseFragment {
    Unbinder unbinder;
    private RecyclerView recyclerView;
    private List<JsonBean.CardDataBean> list  = new ArrayList<>();

    @Override
    protected void initDatas() {
        mPersneter.Presenter("http://blog.zhaoliang5156.cn/api/card/card.json");
    }

    @Override
    protected BasePresenter getPresenter() {
        return new MyPersneter();
    }

    @Override
    protected void initView(View inflate) {
        unbinder = ButterKnife.bind(getActivity());
        recyclerView = inflate.findViewById(R.id.recycler_view01);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyAdapter(list,getContext()));
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_ka_guan_li_;
    }

    @Override
    public void onSuccess(String url) {
        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(url, JsonBean.class);
        List<JsonBean.CardDataBean> cardData = jsonBean.getCardData();
        list.addAll(cardData);
    }

    @Override
    public void onError(String url) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
