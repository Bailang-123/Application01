package com.example.demo03.persenter;

import com.example.demo03.base.BasePersneter;
import com.example.demo03.contrat.MyContart;
import com.example.demo03.model.MyModel;

public class MyPersenter extends BasePersneter {

    private MyContart.IModel model;

    @Override
    protected void initModel() {
        model = new MyModel();
    }

    @Override
    public void PersenterInfo(String url) {
        model.ModelInfo(url, new MyContart.Models() {
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
