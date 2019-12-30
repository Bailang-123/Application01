package com.bawei.bailang20191216.model;

import com.bawei.bailang20191216.contrat.MyContrat;
import com.bawei.bailang20191216.util.NetUtils;

import java.util.Map;

public class MyModel implements MyContrat.IModel {
    @Override
    public void getModelInfo(String url, final Map<String, Object> map, Class cls, final MyContrat.Models models) {
        NetUtils.getInstance().getInfoPream(url, cls, map, new NetUtils.getSuccess() {
            @Override
            public void onSuccess(Object o) {
                models.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                models.onError(error);
            }
        });
    }

    @Override
    public void postModelInfo(String url, final Map<String, Object> map, Class cls, final MyContrat.Models models) {
        NetUtils.getInstance().postInfoPream(url, cls, map, new NetUtils.getSuccess() {
            @Override
            public void onSuccess(Object o) {
                models.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                models.onError(error);
            }
        });
    }
}
