package com.example.monthlya.service;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface MyService {
    @GET
    Observable<ResponseBody> getInfoUrl(@Url String url);
    @GET
    Observable<ResponseBody> getInfoPreame(@Url String url, @QueryMap Map<String,Object> map);
    @POST
    Observable<ResponseBody> postInfoPreame(@Url String url, @QueryMap Map<String,Object> map);
}
