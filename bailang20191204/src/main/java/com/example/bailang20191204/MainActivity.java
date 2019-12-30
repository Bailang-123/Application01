package com.example.bailang20191204;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bailang20191204.adapter.MyAdapter;
import com.example.bailang20191204.bean.JsonBean;
import com.example.bailang20191204.util.OkHttpUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  String url="http://172.17.8.100/small/commodity/v1/bannerShow";
  private List<JsonBean.ResultBean> list = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view01);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
