package com.example.demo04.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demo04.MainActivity;
import com.example.demo04.R;
import com.example.demo04.app.MyApp;
import com.example.demo04.bean.MyData;
import com.example.demo04.util.GlideUtils;
import com.example.demo04.view.AddView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final List<MyData.OrderDataBean> list;
    private final Context context;

    public MyAdapter(List<MyData.OrderDataBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.activity_recycler, null);
        RecyclerView.ViewHolder viewHolder = new OneHodel(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OneHodel) {
            ((OneHodel) holder).mBigcheckBox.setChecked(setBigCheck(position));
            ((OneHodel) holder).mBigTv.setText(list.get(position).getShopName() + "");
            SmailAdapter smailAdapter = new SmailAdapter(list.get(position).getCartlist(), position);
            ((OneHodel) holder).recyclerView.setAdapter(smailAdapter);
            ((OneHodel) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    static class OneHodel extends RecyclerView.ViewHolder {
        CheckBox mBigcheckBox;
        TextView mBigTv;
        RecyclerView recyclerView;

        public OneHodel(@NonNull View itemView) {
            super(itemView);
            mBigcheckBox = itemView.findViewById(R.id.Big_CheckBox);
            mBigTv = itemView.findViewById(R.id.Big_Text);
            recyclerView = itemView.findViewById(R.id.small_Recy);
        }

    }

    public boolean setBigCheck(int bigIndex) {
        boolean flag = true;
        MyData.OrderDataBean orderDataBean = list.get(bigIndex);
        for (int i = 0; i < orderDataBean.getCartlist().size(); i++) {
            if (!orderDataBean.getCartlist().get(i).isStatus()) {
                flag = false;
                return flag;
            }
        }
        return flag;
    }

    public class SmailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<MyData.OrderDataBean.CartlistBean> mlist;
        private int bigIndex;

        public SmailAdapter(List<MyData.OrderDataBean.CartlistBean> mlist, int bigIndex) {
            this.mlist = mlist;
            this.bigIndex = bigIndex;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.activity_name, null);
            RecyclerView.ViewHolder viewHolder = new SmailHodler(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof SmailHodler) {
                GlideUtils.GlideInfo(mlist.get(position).getDefaultPic(), ((SmailHodler) holder).mImage);
                ((SmailHodler) holder).mPrice.setText(mlist.get(position).getPrice() + "");
                ((SmailHodler) holder).mSmallName.setText(mlist.get(position).getProductName() + "");

            }
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }

        public class SmailHodler extends RecyclerView.ViewHolder {
            private CheckBox mSmallCheck;
            private TextView mSmallName, mPrice;
            private ImageView mImage;

            public SmailHodler(@NonNull View itemView) {
                super(itemView);
                mSmallCheck = itemView.findViewById(R.id.small_checkbox);
                mSmallName = itemView.findViewById(R.id.small_name);
                mPrice = itemView.findViewById(R.id.small_price);
                mImage = itemView.findViewById(R.id.image_view01);

            }
        }
    }
}
