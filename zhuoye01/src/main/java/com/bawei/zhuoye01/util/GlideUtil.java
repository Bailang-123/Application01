package com.bawei.zhuoye01.util;

import android.widget.ImageView;

import com.bawei.zhuoye01.R;
import com.bawei.zhuoye01.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

public class GlideUtil {
    public static void  GlideInfo(String url, ImageView imageView){
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
