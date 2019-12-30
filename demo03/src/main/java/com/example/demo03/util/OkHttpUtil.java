package com.example.demo03.util;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtil {
    private OkHttpClient okHttpClient;
    private HttpLoggingInterceptor interceptor;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    onOkHttp.onSuccess(msg.obj.toString());
                    break;
                case 2:
                    onOkHttp.onError(msg.obj.toString());
                    break;
            }
        }
    };
    private OkHttpUtil(){
        interceptor = new HttpLoggingInterceptor();;
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }
    public static class NetUtil{
        private static final OkHttpUtil okhttp = new OkHttpUtil();
    }

    public static OkHttpUtil getInstance() {
        return NetUtil.okhttp;
    }
    private OnOkHttp onOkHttp;
    public void syncGet(String url,OnOkHttp monOkHttp){
        onOkHttp = monOkHttp;
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendMessage(handler.obtainMessage(2,e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.sendMessage(handler.obtainMessage(1,response.body().string()));
            }
        });
    }

    public  interface OnOkHttp{
        void onSuccess(String url);
        void onError(String error);
    }
}
