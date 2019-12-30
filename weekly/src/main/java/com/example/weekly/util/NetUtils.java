package com.example.weekly.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.weekly.app.MyApp;
import com.example.weekly.service.MyService;
import com.example.weekly.url.MyUrls;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtils {
    private MyService service;
    public NetUtils(){
        HttpLoggingInterceptor loggingInterceptor  = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        SharedPreferences bailang = MyApp.context.getSharedPreferences("bailang", Context.MODE_PRIVATE);
                        String userId = bailang.getString("userId", "");
                        String sessionId = bailang.getString("sessionId", "");
                        if(TextUtils.isEmpty(userId)||TextUtils.isEmpty(sessionId)){
                            return chain.proceed(chain.request());
                        }else{
                            Request request = chain.request().newBuilder()
                                    .addHeader("userId",userId)
                                    .addHeader("sessionId",sessionId)
                                    .build();
                            Log.e("userId",userId);
                            Log.e("sessionId",sessionId);
                            return chain.proceed(request);
                        }
                    }
                }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUrls.BASEURL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(MyService.class);
    }

    public static  class  Utils{
        private static final NetUtils netutils = new NetUtils();
    }

    public static NetUtils getInstance() {
        return Utils.netutils;
    }

    public void doGet(String url, final Class cls, final NetCallback netCallback){
        service.getInfoNoParams(url).observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            if (netCallback != null) {
                                netCallback.onSuccess(o);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        netCallback.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void postInfo(String url, Map<String,Object> map, final Class cls, final NetCallback netCallback){
        service.getInfoParams(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            netCallback.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("MyMessage",e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getparamesInfo(String url, Map<String,Object> map, final Class cls, final NetCallback netCallback) {
        service.getInfoNotProme(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            netCallback.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("MyMessage",e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface NetCallback<T>{
        void onSuccess(T t);
        void onError(String error);
    }

}
