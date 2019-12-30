package com.example.weekly.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weekly.R;
import com.example.weekly.bean.GsonBean;
import com.example.weekly.util.GlideUtil;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GsonBean.OrderListBean> listBeans ;
    private Context context;

    public MyAdapter(List<GsonBean.OrderListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.activity_name,null);
        RecyclerView.ViewHolder viewHolder = new OneHodler(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof  OneHodler){
            GsonBean.OrderListBean orderListBean = listBeans.get(position);
            OneRecyclerView oneRecyclerView = new OneRecyclerView(orderListBean.getDetailList(),context);
            ((OneHodler) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context));
            ((OneHodler) holder).recyclerView.setAdapter(oneRecyclerView);
        }
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    static class OneHodler extends RecyclerView.ViewHolder {
        RecyclerView recyclerView ;
        public OneHodler(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_view02);
        }
    }

    static class OneRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        List<GsonBean.OrderListBean.DetailListBean> list ;
        Context context;

        public OneRecyclerView(List<GsonBean.OrderListBean.DetailListBean> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(context,R.layout.activity_name02,null);
            RecyclerView.ViewHolder  viewHolder = new TwoHodler(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof TwoHodler){
                ((TwoHodler) holder).textView02.setText(list.get(position).getCommodityName()+"");
                GsonBean.OrderListBean.DetailListBean detailListBean = list.get(position);
                String[] split = detailListBean.getCommodityPic().split(",");
                if(split !=null&&split.length>0){
                    GlideUtil.GldieInfo(split[0],((TwoHodler) holder).imageView01);
                }else{
                    GlideUtil.GldieInfo(detailListBean.getCommodityPic(),((TwoHodler) holder).imageView01);
                }
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        static class TwoHodler extends RecyclerView.ViewHolder {
            ImageView imageView01;
            TextView textView02;
            public TwoHodler(@NonNull View itemView) {
                super(itemView);
                imageView01 = itemView.findViewById(R.id.image_name01);
                textView02 = itemView.findViewById(R.id.text_name02);
            }
        }
    }
}
