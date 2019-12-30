package com.example.project.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIService {
    @GET
    Observable<ResponseBody> doGetInfo(@Url String url);
}
