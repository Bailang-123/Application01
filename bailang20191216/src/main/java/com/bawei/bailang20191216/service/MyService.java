package com.bawei.bailang20191216.service;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface MyService {
    @GET
    Observable<ResponseBody> getInfoPrame(@Url String url, @QueryMap Map<String, Object> map);

    @POST
    Observable<ResponseBody> postInfoPrame(@Url String url, @QueryMap Map<String, Object> map);
}
