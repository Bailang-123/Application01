package com.example.myapplication2.net;

import android.os.Handler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class NetUtil {
    private static NetUtil netUtil;
    private static Handler handler;
    private final OkHttpClient okHttpClient;

    private NetUtil() {
        handler = new Handler();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient();
        okHttpClient.newBuilder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static NetUtil getInstance() {
        if (netUtil == null) {
            synchronized (NetUtil.class) {
                if (netUtil == null) {
                    netUtil = new NetUtil();
                }
            }
        }
        return netUtil;
    }

    public void doGst(String url, final CallBack callBack) {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError("失败");
                    }
                });
            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                if (response != null && response.isSuccessful()) {
                    final String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(string);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onError("失败");
                        }
                    });
                }
            }
        });
    }

    public void doPost(String url, Map<String,String>map , final CallBack callBack) {
        FormBody.Builder builder = new FormBody.Builder();
        for(String key:map.keySet()){
            String s = map.get(key);
            builder.add(key,s);
        }
        FormBody build = builder.build();
        Request request = new Request.Builder()
                .post(build)
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError("失败");
                    }
                });
            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                if (response != null && response.isSuccessful()) {
                    final String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(string);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onError("失败");
                        }
                    });
                }
            }
        });
    }
    public interface CallBack {
        void onSuccess(String json);

        void onError(String throwable);
    }
}
