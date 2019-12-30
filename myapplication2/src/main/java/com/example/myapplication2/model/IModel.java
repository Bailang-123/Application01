package com.example.myapplication2.model;

import com.example.myapplication2.contart.Contarte;
import com.example.myapplication2.net.NetUtil;

public class IModel implements Contarte.MyModel {
    @Override
    public void ModelInfo(String url, Contarte.Models models) {
        NetUtil.getInstance().doGst(url, new NetUtil.CallBack() {
            @Override
            public void onSuccess(String json) {
                models.onSuccess(json);
            }

            @Override
            public void onError(String throwable) {
                models.onError(throwable);
            }
        });
    }
}
