package com.bawei.bailang201912130.model;

import com.bawei.bailang201912130.contart.IContart;
import com.bawei.bailang201912130.util.NetUtils;

public class IModel implements IContart.MyModel {
    @Override
    public void ModelInfo(String url, final IContart.Models models) {
        NetUtils.getInstance().doGet(url, new NetUtils.setSuccess() {
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
