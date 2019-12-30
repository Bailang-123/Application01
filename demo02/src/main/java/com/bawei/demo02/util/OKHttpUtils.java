package com.bawei.demo02.util;

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

public class OKHttpUtils {
    private OkHttpClient okHttpClient;
    private HttpLoggingInterceptor interceptor;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1://成功
                    mcallback.onSuccess(msg.obj.toString());
                    break;
                case 2://失败
                    mcallback.onError(msg.obj.toString());
                    break;
            }
        }
    };
    private OKHttpUtils(){
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    public  static  class OkHodler{
        private static final OKHttpUtils utils = new OKHttpUtils();
    }

    public static OKHttpUtils getInstance() {
        return OkHodler.utils;
    }

    private OkCallback mcallback;

    public void syncGet(final String url, final OkCallback callback){
        mcallback = mcallback;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder().url(url).build();
                String jsonStr = null;
                try {
                    jsonStr = okHttpClient.newCall(request).execute().body().string();
                    handler.sendMessage(handler.obtainMessage(0,jsonStr));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    //同步get请求
    public void  syncPost(String url,FormBody formBody,OkCallback callback) throws IOException {
        Request request = new Request.Builder().url(url).method("Post",formBody).build();
        okHttpClient.newCall(request).execute().body().string();
    }
    //异步get
    public void  asyncGet(String url,OkCallback callback){
        mcallback = callback;
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendMessage(handler.obtainMessage(2,e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.sendMessage(handler.obtainMessage(1,response));
            }
        });
    }
    public  void  asyncPost(String url, FormBody formBody, final OkCallback callback){
        mcallback = mcallback;
        Request request = new Request.Builder().method("Post",formBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendMessage(handler.obtainMessage(2,e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.sendMessage(handler.obtainMessage(1,response));
            }
        });
    }

//异步post
//    public void  asyncPost(String url, FormBody formBody,OkCallback callback){
//        mcallback = callback;
//        Request request = new Request.Builder().method("Post",formBody).url(url).build();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                handler.sendMessage(handler.obtainMessage(2,e.getMessage()));
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                handler.sendMessage(handler.obtainMessage(1,response));
//            }
//        });
//    }

    public interface  OkCallback{
        void onSuccess(String url);
        void onError(String error);
    }
}
