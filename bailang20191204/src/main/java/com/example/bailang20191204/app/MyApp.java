package com.example.bailang20191204.app;

import android.app.Application;
import android.content.Context;

import com.google.gson.internal.GsonBuildConfig;

import retrofit2.Retrofit;

public class MyApp extends Application {
    public static Context context;
    public static Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}