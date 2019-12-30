package com.bawei.bailang20191209.model;

import com.bawei.bailang20191209.cotrate.ICotrate;
import com.bawei.bailang20191209.util.NetUtils;

public class MyModels implements ICotrate.IModel {
    @Override
    public void ModelInfo(final String url, Class cls, final ICotrate.ModelsNetCall modelsNetCall) {
        NetUtils.getInstance().doGet(url, cls, new NetUtils.NetCallBack() {
            @Override
            public void onSuccess(Object o) {
                modelsNetCall.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                modelsNetCall.onError(error);
            }
        });
    }
}
