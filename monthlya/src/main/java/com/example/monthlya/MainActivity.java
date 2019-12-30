package com.example.monthlya;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monthlya.adapter.OneAdapter;
import com.example.monthlya.adapter.TwoAdapter;
import com.example.monthlya.base.BaseActivity;
import com.example.monthlya.base.BasePresenter;
import com.example.monthlya.bean.GsonBean;
import com.example.monthlya.presenter.MyPresenter;
import com.example.monthlya.url.MyUrls;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private List<GsonBean.ResultBean> one_list = new ArrayList<>();
    private List<GsonBean.ResultBean.SecondCategoryVoBean> two_list = new ArrayList<>();
    private OneAdapter myoneadapter;
    private TwoAdapter mytwoadapter;
    private RecyclerView recycler_view_one;
    private RecyclerView recycler_view_two;

    @Override
    protected void startEromty() {
        recycler_view_two.setAdapter(mytwoadapter);
        recycler_view_one.setAdapter(myoneadapter);
        myoneadapter.setItemClick(new OneAdapter.ItemClick() {
            @Override
            public void setIndex(int position) {
                myoneadapter.setTextColor(position);
                two_list.clear();
                two_list.addAll(one_list.get(position).getSecondCategoryVo());
                mytwoadapter.notifyDataSetChanged();
            }
        });
        mpresenter.getPresenterInfo(MyUrls.SHOUYE, GsonBean.class);
    }

    @Override
    protected void initView() {
        mytwoadapter = new TwoAdapter(two_list, this);
        myoneadapter = new OneAdapter(one_list, this);
        recycler_view_two = findViewById(R.id.recycler_view_two);
        recycler_view_two.setLayoutManager(new GridLayoutManager(this, 3));
        recycler_view_one = findViewById(R.id.recycler_view_one);
        recycler_view_one.setLayoutManager(new LinearLayoutManager(this));
        Log.e("twoList",two_list.size()+"");
        Log.e("oneList",one_list.size()+"");
    }

    @Override
    protected BasePresenter getpresenter() {
        return new MyPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof GsonBean) {
            one_list.addAll(((GsonBean) o).getResult());
            myoneadapter.notifyDataSetChanged();
            two_list.addAll(one_list.get(0).getSecondCategoryVo());
            mytwoadapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String url) {

    }

}
