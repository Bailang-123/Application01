package com.bawei.demo02.util;

import android.os.Handler;
import android.os.Message;

import com.bawei.demo02.R;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpUtil {
    private OkHttpClient mhttpClient;
    private HttpLoggingInterceptor interceptor;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mcallback.onSuccess(msg.obj.toString());
                    break;
                case 2:
                    mcallback.onError(msg.obj.toString());
                    break;
            }
        }
    };
    private OkhttpUtil(){
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mhttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    public static class okHttpUtil{
        private static  final OkhttpUtil http = new OkhttpUtil();
    }

    public static OkhttpUtil getInstance() {
        return okHttpUtil.http;
    }

    private OnCallback mcallback;

    public void syncGet(final String url, OnCallback callback){
        mcallback = callback;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder().url(url).build();
                String jsonstr= null;
                try {
                    jsonstr = mhttpClient.newCall(request).execute().body().string();
                    handler.sendMessage(handler.obtainMessage(0,jsonstr));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void syncPost(String url, FormBody formBody,OnCallback callback) throws IOException {
        Request request = new Request.Builder().method("Post",formBody).url(url).build();
        mhttpClient.newCall(request).execute().body();
    }

    public void asyncGet(String url,OnCallback callback){
        mcallback = callback;
        final Request request = new Request.Builder().url(url).build();
        mhttpClient.newCall(request).enqueue(new Callback() {
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

    public void asyncPost(String url,FormBody formBody,OnCallback callback){
        mcallback = callback;
        Request request = new Request.Builder().method("Post",formBody).url(url).build();
        mhttpClient.newCall(request).enqueue(new Callback() {
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
    public interface OnCallback{
        void onSuccess(String url);
        void onError(String error);
    }
}
