package com.bawei.zhuoye01.contart;

public interface MyContart {
    interface IModel{
        void ModelInfo(String url,Models models);
    }
    interface IView{
        void OnSuccess(String url);
        void OnError(String error);
    }
    interface IPersenter{
        void PersenterInfo(String url);
    }
    interface Models{
        void OnSuccess(String url);
        void OnError(String error);
    }
}
