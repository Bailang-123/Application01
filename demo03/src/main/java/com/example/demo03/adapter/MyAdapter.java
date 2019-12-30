package com.example.demo03.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demo03.R;
import com.example.demo03.bean.JsonBean;
import com.example.demo03.util.GlideUtil;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<JsonBean.CardDataBean> list;
    private Context context;

    public MyAdapter(List<JsonBean.CardDataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  View.inflate(context,R.layout.activity_name,null);
        RecyclerView.ViewHolder viewHolder = new OneHodler(view);
         return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof  OneHodler){
            GlideUtil.lodeImage(list.get(position).getImageurl(),((OneHodler) holder).imageView);
            ((OneHodler) holder).textView.setText(list.get(position).getBill());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class  OneHodler extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public OneHodler(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image01);
            textView = itemView.findViewById(R.id.text01);
        }
    }
}
