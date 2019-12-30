package com.bawei.zhuoye01.app;

import android.app.Application;
import android.content.Context;

import com.uuzuche.lib_zxing.ZApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class MyApp extends ZApplication {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        ZXingLibrary.initDisplayOpinion(this);
    }
}
