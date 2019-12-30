package com.example.project.contrat;

public interface IContrat {
    interface IModel {
        void MyModel(String url, Class cls, ModelNetCallBack modelNetCallBack);
    }

    interface IView<T> {
        void onSuccess(T t);

        void onError(String error);
    }

    interface IPersenter {
        void PresenterInfo(String url, Class cls);
    }

    interface ModelNetCallBack<T> {
        void onSuccess(T t);

        void onError(String error);
    }
}
