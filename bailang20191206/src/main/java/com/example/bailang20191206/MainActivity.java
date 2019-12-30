package com.example.bailang20191206;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.bailang20191206.bean.JsonBean;
import com.example.bailang20191206.util.NetUtil;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=上衣&page=1&count=5";
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view01);
        NetUtil.getInstance().doGet(url, new NetUtil.SetSuccess() {
            @Override
            public void OnSuccess(String url) {
                Gson gson = new Gson();
                JsonBean jsonBean = gson.fromJson(url, JsonBean.class);
                List<JsonBean.ResultBean> result = jsonBean.getResult();
                Toast.makeText(MainActivity.this, result.get(1).getCommodityName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnError(String error) {

            }
        });
    }
}
