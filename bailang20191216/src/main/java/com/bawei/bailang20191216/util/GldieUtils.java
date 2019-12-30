package com.bawei.bailang20191216.util;

import android.widget.ImageView;

import com.bawei.bailang20191216.R;
import com.bawei.bailang20191216.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

public class GldieUtils {
    public static void GlideInfo(String url, ImageView imageView){
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
