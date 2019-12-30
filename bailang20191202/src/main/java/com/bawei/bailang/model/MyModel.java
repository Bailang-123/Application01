package com.bawei.bailang.model;

import com.bawei.bailang.contract.MyContract;
import com.bawei.bailang.volley.MyVolley;

public class MyModel implements MyContract.IModel {
    @Override
    public void ModelInfo(String url, final MyContract.Models models) {
        MyVolley.getInstance().doGet(url, new MyVolley.setSuccess() {
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
