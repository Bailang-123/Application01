package com.example.bailang20191206.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.bailang20191206.R;
import com.example.bailang20191206.app.MyApp;

public class GlideUtil {
    public static void glideInfo(String url, ImageView view){
        Glide.with(MyApp.context).load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(view);
    }
}
