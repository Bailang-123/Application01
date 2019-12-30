package com.example.weekly.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.weekly.R;
import com.example.weekly.app.MyApp;

public class GlideUtil {
    public  static void GldieInfo(String url, ImageView imageView){
        Glide.with(MyApp.context).load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
