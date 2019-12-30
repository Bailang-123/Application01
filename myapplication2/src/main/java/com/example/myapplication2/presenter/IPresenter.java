package com.example.myapplication2.presenter;

import com.example.myapplication2.base.BasePresenter;
import com.example.myapplication2.contart.Contarte;
import com.example.myapplication2.model.IModel;

public class IPresenter extends BasePresenter {

    private Contarte.MyModel myModel;

    @Override
    protected void initData() {
        myModel = new IModel();
    }

    @Override
    public void PresenterInfo(String url) {
        myModel.ModelInfo(url, new Contarte.Models() {
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
