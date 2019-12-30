package com.example.weekly;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weekly.adapter.MyAdapter;
import com.example.weekly.base.BaseActivity;
import com.example.weekly.base.BasePresenter;
import com.example.weekly.bean.GsonBean;
import com.example.weekly.presenter.MyPresenter;
import com.example.weekly.service.MyService;
import com.example.weekly.url.MyUrls;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends BaseActivity {


    private RecyclerView recycler_view01;
    private List<GsonBean.OrderListBean> listBeans = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startComptry() {
        Map<String,Object> map = new HashMap<>();
        map.put("status",0);
        map.put("page",1);
        map.put("count",5);
        mpresenter.getPresenterInfo( MyUrls.ORDERITEM,GsonBean.class,map);
    }

    @Override
    protected void initView() {
        myAdapter = new MyAdapter(listBeans, this);
        recycler_view01 = findViewById(R.id.recycler_view01);
        recycler_view01.setLayoutManager(new LinearLayoutManager(this));
        recycler_view01.setAdapter(myAdapter);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof GsonBean) {
            listBeans.addAll(((GsonBean) o).getOrderList());
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }


}
