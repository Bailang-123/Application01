package com.bawei.bailang20191209.util;

import android.widget.ImageView;

import com.bawei.bailang20191209.R;
import com.bawei.bailang20191209.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class GlideUtils {
    public static void GliudeInfo(String url, ImageView imageView){
        Glide.with(MyApp.context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
