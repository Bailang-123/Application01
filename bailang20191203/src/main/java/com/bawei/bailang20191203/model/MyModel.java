package com.bawei.bailang20191203.model;

import com.bawei.bailang20191203.contart.MyContart;
import com.bawei.bailang20191203.util.OkHttpUtil;

public class MyModel implements MyContart.IModel {
    @Override
    public void ModelInfo(String url, final MyContart.Models models) {
        OkHttpUtil.getInstance().asyncGet(url, new OkHttpUtil.OkHttp() {
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
