package com.example.monthlya.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.monthlya.R;
import com.example.monthlya.app.MyApp;
import com.example.monthlya.service.MyService;
import com.example.monthlya.url.MyUrls;
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
    private MyService myService;
    private NetUtils(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        SharedPreferences bailang = MyApp.context.getSharedPreferences("bailang", Context.MODE_PRIVATE);
                        String sessionId = bailang.getString("sessionId", "");
                        String userId = bailang.getString("userId", "");
                        if(TextUtils.isEmpty(sessionId)||TextUtils.isEmpty(userId)){
                            return chain.proceed(chain.request());
                        }else{
                            Request build = chain.request().newBuilder()
                                    .addHeader("sessionId", sessionId)
                                    .addHeader("userId", userId)
                                    .build();
                            Log.e("userid", userId);
                            Log.e("sessionId", sessionId);
                            return chain.proceed(build);
                        }
                    }
                }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUrls.BIAOTI)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myService = retrofit.create(MyService.class);

    }
    public static class  MyNetUtil{
        private static final NetUtils netutil = new NetUtils();
    }

    public static NetUtils getInstance() {
        return MyNetUtil.netutil;
    }

    public void doGet(String url,Class cls,setSuccess success){
        myService.getInfoUrl(url).subscribeOn(Schedulers.io())
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

                            success.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        success.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void getInfoPreame(String url, Class cls, Map<String,Object>map, setSuccess success){
        myService.getInfoPreame(url,map).subscribeOn(Schedulers.io())
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
                            success.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        success.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public void postInfoPreame(String url,Class cls,Map<String,Object>map,setSuccess success){
        myService.postInfoPreame(url,map).subscribeOn(Schedulers.io())
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
                            success.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        success.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface setSuccess<T>{
        void onSuccess(T t);
        void onError(String url);
    }
}
