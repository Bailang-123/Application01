package com.bawei.bailang20191216.contrat;

import java.util.Map;

public interface MyContrat {

    interface IModel {
        void getModelInfo(String url, Map<String, Object> map, Class cls, Models models);

        void postModelInfo(String url, Map<String, Object> map, Class cls, Models models);
    }

    interface IView<T> {
        void onSuccess(T t);

        void onError(String error);
    }

    interface IPresenter {
        void getPresenterInfo(String url, Map<String, Object> map, Class cls);

        void postPresenterInfo(String url, Map<String, Object> map, Class cls);
    }

    interface Models<T> {
        void onSuccess(T t);

        void onError(String error);
    }
}
