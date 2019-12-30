package com.example.demo04.model;

import com.example.demo04.contract.IContarct;
import com.example.demo04.util.NetUtils;

import java.util.Map;

public class MyModel implements IContarct.IModel {

    @Override
    public void doGetNotParams(String url, Class cls, final IContarct.ModelCallback callback) {
        NetUtils.getInstance().getInfo(url, cls, new NetUtils.NetCallback() {
            @Override
            public void onSuccess(Object o) {
                callback.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                callback.onError(error);
            }
        });
    }

}
