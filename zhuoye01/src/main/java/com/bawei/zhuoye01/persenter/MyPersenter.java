package com.bawei.zhuoye01.persenter;

import com.bawei.zhuoye01.base.BasePersenter;
import com.bawei.zhuoye01.contart.MyContart;
import com.bawei.zhuoye01.model.MyModel;

public class MyPersenter extends BasePersenter {
   private MyContart.IModel model;
    @Override
    protected void initDate() {
        model = new MyModel();
    }

    @Override
    public void PersenterInfo(String url) {
        model.ModelInfo(url, new MyContart.Models() {
            @Override
            public void OnSuccess(String url) {
                getVew().OnSuccess(url);
            }

            @Override
            public void OnError(String error) {
                getVew().OnError(error);
            }
        });
    }
}
