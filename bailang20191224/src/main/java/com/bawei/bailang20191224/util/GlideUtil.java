package com.bawei.bailang20191224.util;

import android.widget.ImageView;

import com.bawei.bailang20191224.R;
import com.bawei.bailang20191224.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

public class GlideUtil {
    public static void glideInfo(String url, ImageView imageView){
        Glide.with(MyApp.context).load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
