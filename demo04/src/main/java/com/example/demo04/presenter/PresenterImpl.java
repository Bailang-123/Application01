package com.example.demo04.presenter;

import com.example.demo04.base.BasePresenter;
import com.example.demo04.contract.IContarct;
import com.example.demo04.model.MyModel;

import java.util.Map;

public class PresenterImpl extends BasePresenter {

    private MyModel myModel;

    @Override
    protected void initModel() {
        myModel = new MyModel();
    }

    @Override
    public void startGetNoParamsRequest(String url, Class cls) {
        myModel.doGetNotParams(url, cls, new IContarct.ModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
