package com.bawei.bailang20191209.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bailang20191209.R;
import com.bawei.bailang20191209.bean.MyData;
import com.bawei.bailang20191209.util.GlideUtils;
import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.http.Url;
/*
* 姓名:白烺
* 作品:适配器*/
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    //初始化
    private List<MyData.OrderDataBean> list;
    static Context context;
    //构造方法
    public MyAdapter(List<MyData.OrderDataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //找控件
        View view = View.inflate(context,R.layout.activity_one,null);
        RecyclerView.ViewHolder viewHolder = new OneHodler(view);
        return viewHolder;
    }
    //给数据赋值
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof OneHodler){
            ((OneHodler) holder).OneView.setText(list.get(position).getShopName());
            ((OneHodler) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context));
            TwoAdapter twoAdapter = new TwoAdapter(list.get(position).getCartlist(),position);
            ((OneHodler) holder).recyclerView.setAdapter(twoAdapter);
        }
    }
    //返回list长度
    @Override
    public int getItemCount() {
        return list.size();
    }
    //内部类
    static class OneHodler extends RecyclerView.ViewHolder {
        TextView OneView;
        RecyclerView recyclerView;
        public OneHodler(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_view_one);
            OneView = itemView.findViewById(R.id.text_one);
        }
    }
    public static class TwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        //初始化
        private  List<MyData.OrderDataBean.CartlistBean> mlist;
        private  int ints;

        public TwoAdapter(List<MyData.OrderDataBean.CartlistBean> mlist, int ints) {
            this.mlist = mlist;
            this.ints = ints;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mview = View.inflate(context,R.layout.activity_two,null);
            RecyclerView.ViewHolder viewHolder = new TwoHodel(mview);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof TwoHodel){
                GlideUtils.GliudeInfo(mlist.get(position).getDefaultPic(),((TwoHodel) holder).imageView);
                ((TwoHodel) holder).textView_name.setText(mlist.get(position).getProductName());
                ((TwoHodel) holder).textView_price.setText(mlist.get(position).getPrice());
            }
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }

        static class TwoHodel extends RecyclerView.ViewHolder {
            TextView textView_name,textView_price;
            ImageView imageView ;
            public TwoHodel(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_two);
                textView_name = itemView.findViewById(R.id.text_two_name);
                textView_price = itemView.findViewById(R.id.text_two_price);
            }
        }
    }
}
