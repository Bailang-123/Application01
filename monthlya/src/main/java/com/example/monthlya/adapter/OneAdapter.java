package com.example.monthlya.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monthlya.R;
import com.example.monthlya.bean.GsonBean;

import java.util.List;

public class OneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GsonBean.ResultBean> list ;
    private Context context;
    private int count = 0;

    public OneAdapter(List<GsonBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = View.inflate(context, R.layout.item_one,null);
        RecyclerView.ViewHolder viewHolder = new OneHodler(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof OneHodler){
            ((OneHodler) holder).textView.setText(list.get(position).getName()+"");
            if(count==position){
                ((OneHodler) holder).textView.setTextColor(Color.RED);
            }else{
                ((OneHodler) holder).textView.setTextColor(Color.BLACK);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClick != null) {
                        itemClick.setIndex(position);
                    }
                }
            });
        }
    }
    public interface ItemClick{
        void setIndex(int position);
    }
    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class OneHodler extends RecyclerView.ViewHolder {
        TextView textView;
        public OneHodler(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.One_Text);
        }
    }


    public void  setTextColor(int position){
        this.count = position;
        notifyDataSetChanged();
    }
}
