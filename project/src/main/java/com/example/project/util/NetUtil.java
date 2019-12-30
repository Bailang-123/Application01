package com.example.project.util;

import com.example.project.api.APIService;
import com.example.project.myutils.MyUtils;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtil {

    private final APIService apiService;

    private NetUtil() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUtils.FRONT)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    public static class Net {
        public static final NetUtil MY_UTIL = new NetUtil();
    }

    public static NetUtil getInstance() {
        return Net.MY_UTIL;
    }

    public interface NetCallBack<T> {
        void onSuccess(T t);

        void onError(String error);
    }

    public void doGet(String url, final Class cls, final NetCallBack netCallBack) {
        apiService.doGetInfo(url).subscribeOn(Schedulers.io())
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
                            if (netCallBack != null) {
                                netCallBack.onSuccess(o);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (netCallBack != null) {
                            netCallBack.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
