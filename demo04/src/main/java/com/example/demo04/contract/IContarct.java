package com.example.demo04.contract;

import java.util.Map;

public interface IContarct {
    interface IModel {
        //没有参数的时候
        void doGetNotParams(String url, Class cls, ModelCallback callback);

    }

    interface IView<T> {
        void onSuccess(T t);

        void onError(String error);
    }

    interface IPresenter {
        void startGetNoParamsRequest(String url, Class cls);

    }

    interface ModelCallback<T> {
        void onSuccess(T t);

        void onError(String error);
    }
}
