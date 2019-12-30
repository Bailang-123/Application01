package com.bawei.bailang20191209.util;

import com.bawei.bailang20191209.api.APIService;
import com.bawei.bailang20191209.myutil.MyUtils;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Timeout;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

public class NetUtils {
    private HttpLoggingInterceptor interceptor;
    private APIService apiService;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    public NetUtils(){
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                                                                                                                                                                                                                                                                                                                                                                                     okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(MyUtils.HANDHTTP)
                .client(okHttpClient)

                
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    public void doGet(String url, final Class cls, final NetCallBack netCallBack){
        apiService.getInfoDoGet(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RequestBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RequestBody requestBody) {
                        Gson gson = new Gson();
                        Object o = gson.fromJson(requestBody.toString(), cls);
                        if (netCallBack != null) {
                            netCallBack.onSuccess(o);
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
    public static class Myutils{
        private static final NetUtils net_utils =  new NetUtils();
    }

    public static NetUtils getInstance() {
        return Myutils.net_utils;
    }

    public interface NetCallBack<T>{
        void onSuccess(T t);
        void onError(String error);
    }
}
