package com.example.demo04.util;

import com.example.demo04.api.ApiService;
import com.example.demo04.url.MyUrls;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtils {
    private ApiService apiService;

    private NetUtils() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUrls.BASEURL)
                .client(okHttpClient)
                //结合Rxjava使用/
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    private static class NetHodler {
        private static final NetUtils netUtils = new NetUtils();
    }

    public static NetUtils getInstance() {
        return NetHodler.netUtils;
    }

    public void getInfo(String url, final Class cls, final NetCallback netCallback) {
        apiService.getInfoNoParams(url).subscribeOn(Schedulers.io())//被观察者在什么线程上工作
                .observeOn(AndroidSchedulers.mainThread())//观察者相应一般都是在主线程
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
                        if (netCallback != null) {
                            netCallback.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface NetCallback<T> {
        void onSuccess(T t);

        void onError(String error);
    }
}
