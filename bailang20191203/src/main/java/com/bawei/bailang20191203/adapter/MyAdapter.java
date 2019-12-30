package com.bawei.bailang20191203.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bailang20191203.R;
import com.bawei.bailang20191203.bean.JsonBean;
import com.bawei.bailang20191203.util.GlideUtil;
import com.bumptech.glide.Glide;

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
        RecyclerView.ViewHolder viewHolder = null;
        View view = null;
        view = View.inflate(context,R.layout.activity_name,null);
        viewHolder = new OneHodler(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       if(holder instanceof  OneHodler){
           GlideUtil.GlideInfo(list.get(position).getImageurl(),((OneHodler) holder).imageView);
           ((OneHodler) holder).textView.setText(list.get(position).getTotal());
       }
    }
    static class OneHodler extends RecyclerView.ViewHolder {
         ImageView imageView;
         TextView textView;
        public OneHodler(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_View02);
            textView = itemView.findViewById(R.id.text02);
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
