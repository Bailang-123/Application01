package com.bawei.bailang20191209;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CheckBox;

import com.bawei.bailang20191209.adapter.MyAdapter;
import com.bawei.bailang20191209.api.APIService;
import com.bawei.bailang20191209.app.MyApp;
import com.bawei.bailang20191209.base.BaseActivity;
import com.bawei.bailang20191209.base.BasePersenter;
import com.bawei.bailang20191209.bean.MyData;
import com.bawei.bailang20191209.myutil.MyUtils;
import com.bawei.bailang20191209.presenter.MyPresenter;
import com.bawei.bailang20191209.util.NetStart;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
/*
* 姓名:白烺
* 作品:mainactivity*/
public class MainActivity extends BaseActivity {
    private List<MyData.OrderDataBean> list = new ArrayList<>();
    @BindView(R.id.recycler_view_one)
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    @Override
    protected void initView() {
        myAdapter = new MyAdapter(list,this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    protected void startComprty() {
        mpresenter.PersenterInfo(MyUtils.DOWNHTTP,MyData.class);
    }

    @Override
    protected BasePersenter getPersenter() {
        return new MyPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object url) {
        if(NetStart.hasNet(this)){
            if(url instanceof MyData){
                list.addAll(((MyData) url).getOrderData());
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
