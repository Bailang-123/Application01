package com.bawei.bailang20191224.model;

import com.bawei.bailang20191224.contart.MyContarte;
import com.bawei.bailang20191224.url.MyUrls;
import com.bawei.bailang20191224.util.NetUtil;

import java.util.Map;

public class IModel implements MyContarte.MyModel {
    @Override
    public void ModelGetInfo(String url, final Map<String, Object> map, Class cls, final MyContarte.Models models) {
        NetUtil.getInstance().getInfoPreame(url, map, cls, new NetUtil.setSuccess() {
            @Override
            public void OnSuccess(Object o) {
                models.OnSuccess(o);
            }

            @Override
            public void OnError(String error) {
                models.OnError(error);
            }
        });
    }

    @Override
    public void ModelPostInfo(String url, Map<String, Object> map, Class cls, MyContarte.Models models) {

    }
}
