package com.example.monthlya.modle;

import com.example.monthlya.contrat.IContrat;
import com.example.monthlya.util.NetUtils;

import java.util.Map;

public class MyModle implements IContrat.IModel {
    @Override
    public void getmodelInfo(String url, Class cls, IContrat.Models models) {
        NetUtils.getInstance().doGet(url, cls, new NetUtils.setSuccess() {
            @Override
            public void onSuccess(Object o) {
                models.onSuccess(o);
            }

            @Override
            public void onError(String url) {
                models.onError(url);
            }
        });
    }

    @Override
    public void postmodelInfo(String url, Class cls, Map<String, Object> map, IContrat.Models models) {
        NetUtils.getInstance().postInfoPreame(url, cls, map, new NetUtils.setSuccess() {
            @Override
            public void onSuccess(Object o) {
                models.onSuccess(o);
            }

            @Override
            public void onError(String url) {
                models.onError(url);
            }
        });
    }
}
