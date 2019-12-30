package com.bawei.zhuoye01.model;

import com.bawei.zhuoye01.contart.MyContart;
import com.bawei.zhuoye01.util.MyVolley;

public class MyModel implements MyContart.IModel {
    @Override
    public void ModelInfo(String url, final MyContart.Models models) {
        MyVolley.getInstance().doGet(url, new MyVolley.setSuccess() {
            @Override
            public void OnSuccess(String url) {
                models.OnSuccess(url);
            }

            @Override
            public void OnError(String error) {
                models.OnError(error);
            }
        });
    }
}
