package com.bawei.bailang20191216;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bawei.bailang20191216.adapter.MyAdapter;
import com.bawei.bailang20191216.base.BaseActivity;
import com.bawei.bailang20191216.base.BasePresenter;
import com.bawei.bailang20191216.bean.JosnBean;
import com.bawei.bailang20191216.presenter.MyPresenter;
import com.bawei.bailang20191216.url.MyUrls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends BaseActivity {


    private RecyclerView recyclerView;
    private List<JosnBean.OrderListBean> listBeans = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startEormay() {
        myAdapter = new MyAdapter(listBeans,this);
        recyclerView.setAdapter(myAdapter);
        Map<String,Object> map = new HashMap<>();
        map.put("status",0);
        map.put("page",1);
        map.put("count",5);

        mpresenter.getPresenterInfo(MyUrls.LIEWEI,map,JosnBean.class);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recycler_view01);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof JosnBean){
            listBeans.addAll(((JosnBean) o).getOrderList());
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
