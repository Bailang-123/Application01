package com.bawei.demo02.model;

import com.bawei.demo02.contract.MyContract;
import com.bawei.demo02.util.OkhttpUtil;

public class MyModel implements MyContract.IModel {
    @Override
    public void getInfo(String url, final MyContract.ModelCallback callback) {
        OkhttpUtil.getInstance().asyncGet(url, new OkhttpUtil.OnCallback() {
            @Override
            public void onSuccess(String url) {
                callback.onSuccess(url);
            }

            @Override
            public void onError(String error) {
                callback.onError(error);
            }
        });
    }
}
