package com.example.demo03.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.demo03.R;
import com.example.demo03.app.MyApp;

public class GlideUtil {
    public static void lodeImage(String url, ImageView imageView){
        Glide.with(MyApp.context).load(url)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
