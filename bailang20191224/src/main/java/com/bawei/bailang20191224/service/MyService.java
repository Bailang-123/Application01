package com.bawei.bailang20191224.service;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface MyService{
    @GET
    Observable<Response>doGetInfo(@Url String url);
    @GET
    Observable<Response> getInfoPrame(@Url String url, @QueryMap Map<String,Object> map);
    @POST
    Observable<Response> postInfoPrame(@Url String url, @QueryMap Map<String,Object> map);

}
