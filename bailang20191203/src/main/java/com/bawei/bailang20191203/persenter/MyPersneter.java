package com.bawei.bailang20191203.persenter;

import com.bawei.bailang20191203.base.BasePresenter;
import com.bawei.bailang20191203.contart.MyContart;
import com.bawei.bailang20191203.model.MyModel;

public class MyPersneter extends BasePresenter {

    private MyContart.IModel model;

    @Override
    protected void initData() {
        model = new MyModel();
    }

    @Override
    public void Presenter(String url) {
        model.ModelInfo(url, new MyContart.Models() {
            @Override
            public void onSuccess(String url) {
                getView().onSuccess(url);
            }

            @Override
            public void onError(String url) {
                getView().onError(url);
            }
        });
    }
}
