package com.bawei.bailang20191216.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bailang20191216.R;
import com.bawei.bailang20191216.bean.JosnBean;
import com.bawei.bailang20191216.util.GldieUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private List<JosnBean.OrderListBean> listBeans;
    private Context context;

    public MyAdapter(List<JosnBean.OrderListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.activity_name01, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        JosnBean.OrderListBean orderListBean = listBeans.get(position);
        OneAdapter oneAdapter = new OneAdapter(orderListBean.getDetailList(), context);
        holder.recyclerView.setAdapter(oneAdapter);
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_view02);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
    }


    static class OneAdapter extends RecyclerView.Adapter<OneAdapter.OneHolder> {
        private List<JosnBean.OrderListBean.DetailListBean> listBeans;
        private Context context;

        public OneAdapter(List<JosnBean.OrderListBean.DetailListBean> listBeans, Context context) {
            this.listBeans = listBeans;
            this.context = context;
        }


        @NonNull
        @Override
        public OneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.activity_name02, null);
            OneHolder holder = new OneHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull OneHolder holder, int position) {
            holder.textView_name.setText(listBeans.get(position).getCommodityName());
            holder.textView_price.setText(listBeans.get(position).getCommodityPrice() + "");
            JosnBean.OrderListBean.DetailListBean detailListBean = listBeans.get(position);
            String[] split = detailListBean.getCommodityPic().split(",");

            if(split!=null&&split.length>0){
               GldieUtils.GlideInfo(split[0],holder.imageView_name);
            }else {
                GldieUtils.GlideInfo(detailListBean.getCommodityPic(),holder.imageView_name);
            }

        }

        @Override
        public int getItemCount() {
            return listBeans.size();
        }

        public class OneHolder extends RecyclerView.ViewHolder {
            ImageView imageView_name;
            TextView textView_name;
            TextView textView_price;

            public OneHolder(@NonNull View itemView) {
                super(itemView);
                imageView_name = itemView.findViewById(R.id.image123);
                textView_name = itemView.findViewById(R.id.text_phone);
                textView_price = itemView.findViewById(R.id.text_price);
            }
        }


    }


}
