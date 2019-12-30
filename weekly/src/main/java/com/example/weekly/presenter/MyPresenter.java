package com.example.weekly.presenter;

import com.example.weekly.base.BasePresenter;
import com.example.weekly.contrat.IContrat;
import com.example.weekly.model.MyModel;

import java.util.Map;

public class MyPresenter extends BasePresenter {

    private MyModel myModel;


    @Override
    public void getPresenterInfo(String url, Class cls, Map<String, Object> map) {
        myModel.getModelInfo(url, cls, map, new IContrat.Models() {
            @Override
            public void onSuccess(Object o) {
                getview().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getview().onError(error);
            }
        });
    }

    @Override
    public void postPresenterInfo(String url, Class cls, Map<String, Object> map) {
        myModel.postModelInfo(url, cls, map, new IContrat.Models() {
            @Override
            public void onSuccess(Object o) {
                getview().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getview().onError(error);
            }
        });
    }

    @Override
    protected void initData() {
        myModel = new MyModel();
    }
}
