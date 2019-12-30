package com.bawei.demo02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.demo02.R;
import com.bawei.demo02.bean.JavaBean;
import com.bawei.demo02.util.GlideUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<JavaBean.ResultBean> mList;
    private Context mContext;

    public MyAdapter(List<JavaBean.ResultBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_layout, null);
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {




    }
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        GlideUtils.loadImage(mList.get(i).getMasterPic(), holder.mImage);
        holder.mText.setText(mList.get(i).getCommodityName() + "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClick != null) {
                    itemClick.setOnItemClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView mImage;
        TextView mText;
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }


    public interface ItemClick {
        void setOnItemClick(int position);
    }

    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }
}
