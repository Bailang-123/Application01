package com.example.demo04.fragment2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo04.R;
import com.example.demo04.adapter.MyAdapter;
import com.example.demo04.base.BaseFragment;
import com.example.demo04.base.BasePresenter;
import com.example.demo04.bean.MyData;
import com.example.demo04.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

public class QBFragment extends BaseFragment {
    private MyAdapter myAdapter;
    private List<MyData.OrderDataBean> list = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void startCompry() {
        myAdapter = new MyAdapter(list,getContext());
        recyclerView.setAdapter(myAdapter);
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
        recyclerView = inflate.findViewById(R.id.recycler_view01);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_qb;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof MyData){
            list.addAll(((MyData)o).getOrderData());
        }
    }

    @Override
    public void onError(String error) {

    }
}
