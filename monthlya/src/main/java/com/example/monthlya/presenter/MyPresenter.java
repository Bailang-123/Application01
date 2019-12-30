package com.example.monthlya.presenter;

import com.example.monthlya.base.BasePresenter;
import com.example.monthlya.contrat.IContrat;
import com.example.monthlya.modle.MyModle;

import java.util.Map;

public class MyPresenter extends BasePresenter {

    private MyModle myModle;

    @Override
    protected void initData() {
        myModle = new MyModle();
    }

    @Override
    public void getPresenterInfo(String url, Class cls) {
        myModle.getmodelInfo(url, cls, new IContrat.Models() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String url) {
                getView().onError(url);
            }
        });
    }

    @Override
    public void postPresenterInfo(String url, Class cls, Map<String,Object> map) {
        myModle.postmodelInfo(url, cls, map, new IContrat.Models() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String url) {
                getView().onError(url);
            }
        });
    }
}
