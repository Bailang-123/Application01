package com.bawei.bailang201912130.util;

import android.os.Handler;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class NetUtils {
    private Handler handler;
    private NetUtils(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }
    public static class Utils{
        private static final NetUtils netutils = new NetUtils();
    }

    public static NetUtils getInstance() {
        return Utils.netutils;
    }

    public void doGet(final String url, final setSuccess success){
        handler.post(new Runnable() {
            @Override
            public void run() {
                success.onSuccess(url);
            }
        });
    }

    public interface setSuccess{
        void onSuccess(String url);
        void onError(String error);
    }
}
