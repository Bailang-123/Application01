package com.bawei.bailang20191224.util;

import android.app.AppComponentFactory;
import android.content.SyncAdapterType;

import com.bawei.bailang20191224.service.MyService;
import com.bawei.bailang20191224.url.MyUrls;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.security.cert.CertificateFactory;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class NetUtil {
    MyService myService;
    public NetUtil (){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(MyUrls.HAND)
                .client(client)
                .build();
    }

    public static class Netutils{
        private static final NetUtil NET_UTIL = new NetUtil();
    }

    public static NetUtil getInstance() {
        return NetUtil.getInstance();
    }

    public void doGet(String url,setSuccess success){
//        myService.doGetInfo(url)
    }
    public void getInfoPreame(String url,Map<String,Object> map,Class cls,setSuccess success){}
    public void postInfoPreame(String url,Map<String,Object> map,Class cls,setSuccess success){}

    public interface setSuccess<T>{
        void OnSuccess(T t);
        void OnError(String error);
    }

}
