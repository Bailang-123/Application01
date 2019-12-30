package com.example.demo04.api;

import com.example.demo04.bean.MyData;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Url;

public interface ApiService {
    Observable<ResponseBody> getInfoNoParams(@Url String url);
}
