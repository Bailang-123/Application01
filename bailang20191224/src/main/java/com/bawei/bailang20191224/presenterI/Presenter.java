package com.bawei.bailang20191224.presenterI;

import com.bawei.bailang20191224.base.BasePresenter;
import com.bawei.bailang20191224.contart.MyContarte;
import com.bawei.bailang20191224.model.IModel;

import java.util.Map;

public class Presenter extends BasePresenter {

    private IModel model;

    @Override
    protected void initData() {
        model = new IModel();
    }

    @Override
    public void MyGetPresenter(String url, Map<String, Object> map, Class cls) {
        model.ModelGetInfo(url, map, cls, new MyContarte.Models() {
            @Override
            public void OnSuccess(Object o) {
                getView().OnSuccess(o);
            }

            @Override
            public void OnError(String error) {
                getView().OnError(error);
            }
        });
    }

    @Override
    public void MyPostPresenter(String url, Map<String, Object> map, Class cls) {
        model.ModelPostInfo(url, map, cls, new MyContarte.Models() {
            @Override
            public void OnSuccess(Object o) {
                getView().OnSuccess(o);
            }

            @Override
            public void OnError(String error) {
                getView().OnError(error);
            }
        });
    }
}
