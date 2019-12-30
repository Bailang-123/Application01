package com.bawei.bailang20191216.presenter;

import android.util.Log;

import com.bawei.bailang20191216.base.BasePresenter;
import com.bawei.bailang20191216.contrat.MyContrat;
import com.bawei.bailang20191216.model.MyModel;

import java.net.URLEncoder;
import java.util.Map;

public class MyPresenter extends BasePresenter {

    private MyContrat.IModel iModel;

    @Override
    protected void initData() {
        iModel = new MyModel();
    }

    @Override
    public void getPresenterInfo(String url, Map<String, Object> map, Class cls) {
        iModel.getModelInfo(url, map, cls, new MyContrat.Models() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
                Log.e("tt", "onSuccess: "+o );
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void postPresenterInfo(String url, Map<String, Object> map, Class cls) {
        iModel.postModelInfo(url, map, cls, new MyContrat.Models() {
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
