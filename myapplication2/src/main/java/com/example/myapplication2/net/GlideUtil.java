package com.example.myapplication2.net;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.myapplication2.R;
import com.example.myapplication2.app.MyApp;

public class GlideUtil {
    public static void Glides(String url, ImageView imageView){
        Glide.with(MyApp.context).load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
