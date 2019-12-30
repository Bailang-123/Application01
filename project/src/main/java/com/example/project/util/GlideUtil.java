package com.example.project.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.project.R;
import com.example.project.app.MyApp;

public class GlideUtil {
    public static void ImageGlideInfo(String url, ImageView imageView){
        Glide.with(MyApp.context).load(url)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
