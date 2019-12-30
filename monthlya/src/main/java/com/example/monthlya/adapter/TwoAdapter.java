package com.example.monthlya.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monthlya.R;
import com.example.monthlya.bean.GsonBean;

import org.w3c.dom.Text;

import java.util.List;

public class TwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GsonBean.ResultBean.SecondCategoryVoBean> two_list;
    private Context context;

    public TwoAdapter(List<GsonBean.ResultBean.SecondCategoryVoBean> two_list, Context context) {
        this.two_list = two_list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.item_two,null);
        TwoHodler viewHolder = new TwoHodler(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TwoHodler){
            ((TwoHodler) holder).textView.setText(two_list.get(position).getName()+"");
            Log.e("text",two_list.get(position).getName());

        }
    }

    @Override
    public int getItemCount() {
        return two_list.size()  ;
    }

    static class TwoHodler extends RecyclerView.ViewHolder {
        TextView textView;
        public TwoHodler(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.Two_Text);
        }
    }
}
