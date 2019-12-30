package com.bawei.bailang20191203.util;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtil {
    private OkHttpClient mokHttpClient;
    private HttpLoggingInterceptor interceptor;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mokHttp.onSuccess(msg.obj.toString());
                    break;
                case 2:
                    mokHttp.onError(msg.obj.toString());
                    break;
            }
        }
    };
    private OkHttpUtil(){
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mokHttpClient  = new OkHttpClient();
        mokHttpClient.newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    public static class MyOkHttpClient {
        private static final OkHttpUtil mhttp= new OkHttpUtil();
    }

    public static OkHttpUtil getInstance() {
        return MyOkHttpClient.mhttp;
    }

   //异步Get请求
    public void asyncGet(String url,OkHttp okHttp){
        mokHttp = okHttp;
        final Request request = new Request.Builder().url(url).build();
        mokHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendMessage(handler.obtainMessage(2,e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.sendMessage(handler.obtainMessage(1,response.body().string()));
            }
        });
    };
//异步Post请求
    public void asyncPost(String url, FormBody formBody, OkHttp okHttp){
        mokHttp = okHttp;
        final Request request = new Request.Builder().method("Post",formBody).url(url).build();
        mokHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendMessage(handler.obtainMessage(2,e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.sendMessage(handler.obtainMessage(1,response.body().string()));
            }
        });
    };


    private OkHttp mokHttp;

    public interface  OkHttp{
         void onSuccess(String url);
         void onError(String error);
    }
}
