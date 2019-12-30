package com.example.weekly.model;

import com.example.weekly.contrat.IContrat;
import com.example.weekly.util.NetUtils;

import java.util.Map;

import retrofit2.http.GET;

public class MyModel implements IContrat.IModel {



    @Override
    public void getModelInfo(String url, Class cls, Map<String, Object> map, final IContrat.Models models) {
        NetUtils.getInstance().getparamesInfo(url, map, cls, new NetUtils.NetCallback() {
            @Override
            public void onSuccess(Object o) {
                models.onSuccess(o);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    @Override
    public void postModelInfo(String url, Class cls, Map<String, Object> map, final IContrat.Models models) {
        NetUtils.getInstance().postInfo(url, map, cls, new NetUtils.NetCallback() {
            @Override
            public void onSuccess(Object o) {
                models.onSuccess(o);
            }

            @Override
            public void onError(String error) {

            }
        });
    }
}
