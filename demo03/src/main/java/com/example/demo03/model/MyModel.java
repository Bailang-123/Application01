package com.example.demo03.model;

import com.example.demo03.contrat.MyContart;
import com.example.demo03.util.OkHttpUtil;

public class MyModel implements MyContart.IModel {
    @Override
    public void ModelInfo(String url, final MyContart.Models models) {
        OkHttpUtil.getInstance().syncGet(url, new OkHttpUtil.OnOkHttp() {
            @Override
            public void onSuccess(String url) {
                models.onSuccess(url);
            }

            @Override
            public void onError(String error) {
                models.onError(error);
            }
        });
    }
}
