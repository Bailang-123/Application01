package com.bawei.demo02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bawei.demo02.adapter.MyAdapter;
import com.bawei.demo02.base.BaseActivity;
import com.bawei.demo02.base.BasePersenter;
import com.bawei.demo02.bean.JavaBean;
import com.bawei.demo02.persenter.MyPersenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    List<JavaBean.ResultBean> list = new ArrayList<>();
    MyAdapter myAdapter;
    @Override
    protected BasePersenter getPresenter() {
        return new MyPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        recyclerView = findViewById(R.id.recycler_view01);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(list,this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    protected void startEncoding() {
        mPresenter.startRequest("http://blog.zhaoliang5156.cn/api/news/lawyer.json");
    }

    @Override
    public void onSuccess(String jsonStr) {
        Gson gson = new Gson();
        JavaBean javaBean = gson.fromJson(jsonStr, JavaBean.class);
        list.addAll(javaBean.getResult());
    }

    @Override
    public void onError(String error) {

    }
}
