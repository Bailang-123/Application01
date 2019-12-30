package com.example.project.model;

import com.example.project.contrat.IContrat;
import com.example.project.util.NetUtil;

public class MyModel implements IContrat.IModel {
    @Override
    public void MyModel(String url, Class cls, final IContrat.ModelNetCallBack modelNetCallBack) {
        NetUtil.getInstance().doGet(url, cls, new NetUtil.NetCallBack() {
            @Override
            public void onSuccess(Object o) {
                modelNetCallBack.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                modelNetCallBack.onError(error);
            }
        });
    }
}
