package com.bawei.bailang20191209.presenter;

import com.bawei.bailang20191209.app.MyApp;
import com.bawei.bailang20191209.base.BasePersenter;
import com.bawei.bailang20191209.cotrate.ICotrate;
import com.bawei.bailang20191209.model.MyModels;

public class MyPresenter extends BasePersenter {

    private ICotrate.IModel model;

    @Override
    protected void initModech() {
        model = new MyModels();
    }

    @Override
    public void PersenterInfo(String url, Class cls) {
        model.ModelInfo(url, cls, new ICotrate.ModelsNetCall() {
            @Override
            public void onSuccess(Object url) {
                getViews().onSuccess(url);
            }

            @Override
            public void onError(String error) {
                getViews().onError(error);
            }
        });
    }
}
