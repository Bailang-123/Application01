package com.bawei.bailang20191224.contart;

import java.util.Map;

public interface MyContarte {
    interface MyModel {
        void ModelGetInfo(String url, Map<String, Object> map,Class cls, Models models);
        void ModelPostInfo(String url, Map<String, Object> map, Class cls,Models models);
    }

    interface MyView<T> {
        void OnSuccess(T t);

        void OnError(String error);
    }

    interface MyPresenter {
        void MyGetPresenter(String url, Map<String, Object> map, Class cls);
        void MyPostPresenter(String url, Map<String, Object> map, Class cls);
    }

    interface Models<T> {
        void OnSuccess(T t);

        void OnError(String error);
    }
}
