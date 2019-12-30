package com.bawei.bailang20191209.cotrate;

public interface ICotrate {
    interface IModel{
        void ModelInfo(String url,Class cls,ModelsNetCall modelsNetCall);
    }
    interface IView<T>{
        void onSuccess(T url);
        void onError(String error);
    }
    interface IPersenter{
        void PersenterInfo(String url,Class cls);
    }
 interface ModelsNetCall<T>{
     void onSuccess(T url);
     void onError(String error);
 }
}
