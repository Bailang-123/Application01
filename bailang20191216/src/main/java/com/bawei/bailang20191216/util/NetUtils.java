package com.bawei.bailang20191216.util;

import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.AndroidRuntimeException;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;

import com.bawei.bailang20191216.R;
import com.bawei.bailang20191216.app.MyApp;
import com.bawei.bailang20191216.service.MyService;
import com.bawei.bailang20191216.url.MyUrls;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.maybe.MaybeIsEmpty;
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

    public NetUtils() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        SharedPreferences sharedPreferences = MyApp.context.getSharedPreferences("bailang", Context.MODE_PRIVATE);
                        String userId = sharedPreferences.getString("userId", "");
                        String sessionId = sharedPreferences.getString("sessionId", "");
                        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(sessionId)) {
                            return chain.proceed(chain.request());
                        } else {
                            Request build = chain.request().newBuilder()
                                    .addHeader("userId", userId)
                                    .addHeader("sessionId", sessionId)
                                    .build();
                            return chain.proceed(build);
                        }

                    }
                })
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUrls.SHOUTOU)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        myService = retrofit.create(MyService.class);

    }

    public static class myNetUtil {
        private static final NetUtils netUtils = new NetUtils();
    }

    public static NetUtils getInstance() {
        return myNetUtil.netUtils;
    }

    public void getInfoPream(String url, final Class cls, Map<String, Object> map, final getSuccess success) {
        myService.getInfoPrame(url, map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            if (success != null) {
                                success.onSuccess(o);
                                Log.e("yy", "onNext: "+o );

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (success != null) {
                            success.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void postInfoPream(String url, final Class cls, Map<String, Object> map, final getSuccess success) {
        myService.postInfoPrame(url, map).subscribeOn(Schedulers.io())
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
                            if (success != null) {
                                success.onSuccess(o);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (success != null) {
                            success.onError(e.getMessage());

                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface getSuccess<T> {
        void onSuccess(T t);

        void onError(String error);
    }
}
