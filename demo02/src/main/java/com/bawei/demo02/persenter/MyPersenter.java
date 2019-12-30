package com.bawei.demo02.persenter;

import com.bawei.demo02.base.BasePersenter;
import com.bawei.demo02.contract.MyContract;
import com.bawei.demo02.model.MyModel;

public class MyPersenter extends BasePersenter {
    private MyContract.IModel model;
    @Override
    protected void initModel() {
        model = new MyModel();
    }

    @Override
    public void startRequest(String url) {
        model.getInfo(url, new MyContract.ModelCallback() {
            @Override
            public void onSuccess(String jsonStr) {
                getView().onSuccess(jsonStr);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
