package com.example.myapplication2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.app.MyApp;
import com.example.myapplication2.base.BaseActivity;
import com.example.myapplication2.base.BasePresenter;
import com.example.myapplication2.bean.JsonBean;
import com.example.myapplication2.net.NetUtil;
import com.example.myapplication2.presenter.IPresenter;
import com.google.gson.Gson;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private List<JsonBean.DataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;
    @Override
    protected void startPresenter() {
        mpresenter.PresenterInfo("http://blog.zhaoliang5156.cn/api/shop/fulishe1.json");
        recyclerView.setAdapter(myAdapter);
        myAdapter = new MyAdapter(list,this);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new IPresenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recycler_view01);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }



    @Override
    public void onSuccess(String url) {
        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(url, JsonBean.class);
        list.addAll(jsonBean.getData());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {

    }
}
