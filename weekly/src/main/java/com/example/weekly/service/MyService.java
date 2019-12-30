package com.example.weekly.service;

import java.util.Map;
import java.util.ResourceBundle;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface MyService {
    @GET
    Observable<ResponseBody> getInfoNoParams(@Url String url);
    @POST
    Observable<ResponseBody> getInfoParams(@Url String url, @QueryMap Map<String,Object> map);
    @GET
    Observable<ResponseBody> getInfoNotProme(@Url String url,@QueryMap Map<String,Object> map);

}
