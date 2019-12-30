package com.bawei.demo02.contract;

public interface MyContract {
    interface IModel {
        void getInfo(String url, ModelCallback callback);
    }

    interface IView {
        void onSuccess(String jsonStr);

        void onError(String error);
    }

    interface IPresenter {
        void startRequest(String url);
    }

    interface ModelCallback {
        void onSuccess(String jsonStr);

        void onError(String error);
    }
}
