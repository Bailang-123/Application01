package com.bawei.bailang.contract;

public interface MyContract  {
    interface IModel{
        void ModelInfo(String url,Models models);
    }
    interface IView{
        void onSuccess(String url);
        void onError(String error);
    }
    interface IPersenter{
        void PersenterInfo(String url);
    }
    interface Models{
        void onSuccess(String url);
        void onError(String error);
    }
}
