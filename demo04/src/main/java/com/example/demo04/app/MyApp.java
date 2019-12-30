package com.example.demo04.app;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    public static Context mContract;

    @Override
    public void onCreate() {
        super.onCreate();
        mContract=this;
    }
}
