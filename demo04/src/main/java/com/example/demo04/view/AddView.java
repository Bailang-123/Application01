package com.example.demo04.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo04.R;

public class AddView extends LinearLayout implements View.OnClickListener {
    private TextView add, sum, remove;

    public AddView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.activity_add, this);
        initView();
    }

    private void initView() {
        add = findViewById(R.id.madd);
        sum = findViewById(R.id.msum);
        remove = findViewById(R.id.mramove);
        add.setOnClickListener(this);
        remove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int count = Integer.parseInt(sum.getText().toString());
        switch (v.getId()) {
            case R.id.madd:
                count++;
                sum.setText(count);
                if (itemCount != null) {
                    itemCount.setItemCount(count);
                }
                break;
            case R.id.mramove:
                if (count > 1) {
                    count--;
                    sum.setText(count);
                    if (itemCount != null) {
                        itemCount.setItemCount(count);
                    } else {
                        Toast.makeText(getContext(), "数量不能为0", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    public interface ItemCount {
        void setItemCount(int number);
    }

    private ItemCount itemCount;

    public void setItemCount(ItemCount itemCount) {
        this.itemCount = itemCount;
    }
}
