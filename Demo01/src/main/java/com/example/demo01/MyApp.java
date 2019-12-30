package com.example.demo01;

import com.uuzuche.lib_zxing.ZApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class MyApp extends ZApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
    }
}
