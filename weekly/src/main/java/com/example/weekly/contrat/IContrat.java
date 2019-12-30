package com.example.weekly.contrat;

import java.util.Map;

public interface IContrat {
    interface IModel {
        void getModelInfo(String url, Class cls, Map<String, Object> map, Models models);

        void postModelInfo(String url, Class cls, Map<String, Object> map, Models models);
    }

    interface IView<T> {
        void onSuccess(T t);

        void onError(String error);
    }

    interface IPresenter {
        void getPresenterInfo(String url, Class cls, Map<String, Object> map);

        void postPresenterInfo(String url, Class cls, Map<String, Object> map);
    }

    interface Models<T> {
        void onSuccess(T t);

        void onError(String error);
    }
}
