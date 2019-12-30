package com.example.bailang20191204.util;

import android.os.Handler;
import android.os.Message;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bailang20191204.app.MyApp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {
    private OkHttpClient mOkHttpClient;
    private HttpLoggingInterceptor interceptor;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    setvolley.onSuccess(msg.obj.toString());
                    break;
                case 2:
                    setvolley.onError(msg.obj.toString());
                    break;
            }
        }
    };
    private setVolley setvolley;
    private OkHttpUtils(){
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient =new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }
    public  static  class okhttp {
        private static  final OkHttpUtils okHttp = new OkHttpUtils();
    }

    public static OkHttpUtils getInstance() {
        return okhttp.okHttp;
    }
    public void  doGet(String url,setVolley volley){
        final Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
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


    public interface setVolley{
        void onSuccess(String url);
        void onError(String error);
    }
}
