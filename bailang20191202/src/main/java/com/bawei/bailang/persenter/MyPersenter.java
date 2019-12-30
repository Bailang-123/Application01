package com.bawei.bailang.persenter;

import com.bawei.bailang.base.BasePersenter;
import com.bawei.bailang.contract.MyContract;
import com.bawei.bailang.model.MyModel;

public class MyPersenter extends BasePersenter {
    private MyContract.IModel model;
    @Override
    protected void initData() {
        model = new MyModel();
    }

    @Override
    public void PersenterInfo(String url) {
        model.ModelInfo(url, new MyContract.Models() {
            @Override
            public void onSuccess(String url) {
                getView().onSuccess(url);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
