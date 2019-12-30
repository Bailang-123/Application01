package com.example.demo03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.demo03.adapter.MyAdapter;
import com.example.demo03.base.BaseActivity;
import com.example.demo03.base.BasePersneter;
import com.example.demo03.bean.JsonBean;
import com.example.demo03.persenter.MyPersenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private List<JsonBean.CardDataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;
    @Override
    protected void startPersenter() {
        mPersenter.PersenterInfo("http://blog.zhaoliang5156.cn/api/card/card.json");
    }

    @Override
    protected BasePersneter getPersenter() {
        return new MyPersenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recycler_view01);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(list,this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String url) {
        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(url, JsonBean.class);
        List<JsonBean.CardDataBean> cardData = jsonBean.getCardData();
        list.addAll(cardData);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {

    }
}
