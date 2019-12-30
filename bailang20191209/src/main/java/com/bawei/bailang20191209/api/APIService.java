package com.bawei.bailang20191209.api;

import java.lang.annotation.Retention;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Url;

public interface APIService {
    Observable<RequestBody> getInfoDoGet(@Url String url);
}
