package com.example.demo04.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.demo04.R;
import com.example.demo04.app.MyApp;

public class GlideUtils {
    public static void GlideInfo(String url, ImageView imageView){
        Glide.with(MyApp.mContract).load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(40)))
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
