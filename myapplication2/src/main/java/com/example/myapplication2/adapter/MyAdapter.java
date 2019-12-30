package com.example.myapplication2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication2.bean.JsonBean;
import com.example.myapplication2.net.GlideUtil;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.OneHodler> {
    private List<JsonBean.DataBean> list;
    private Context context;

    public MyAdapter(List<JsonBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OneHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.activity_name,null);
        return new OneHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OneHodler holder, int position) {
        holder.textView.setText(list.get(position).getGoods_name());
        GlideUtil.Glides(list.get(position).getGoods_thumb(),holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class OneHodler extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public OneHodler(@NonNull View itemView) {
            super(itemView);
            imageView  = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_name);
        }
    }
}
