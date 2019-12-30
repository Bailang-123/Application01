package com.example.demo03.contrat;

public interface MyContart {
    interface IModel{
        void ModelInfo(String url,Models models);
    }
    interface IPersenter{
        void PersenterInfo(String url);
    }
    interface IView{
        void onSuccess(String url);
        void onError(String error);
    }
    interface Models{
        void onSuccess(String url);
        void onError(String error);
    }
}
