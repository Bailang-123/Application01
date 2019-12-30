package com.example.project.presenter;

import com.example.project.base.BasePersenter;
import com.example.project.contrat.IContrat;
import com.example.project.model.MyModel;

public class MyPresenter extends BasePersenter {

    private MyModel myModel;

    @Override
    protected void initMata() {
        myModel = new MyModel();
    }

    @Override
    public void PresenterInfo(String url, Class cls) {
        myModel.MyModel(url, cls, new IContrat.ModelNetCallBack() {
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
}
