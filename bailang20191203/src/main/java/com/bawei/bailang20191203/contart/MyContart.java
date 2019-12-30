package com.bawei.bailang20191203.contart;

public interface MyContart  {
    interface IModel{
        void ModelInfo(String url,Models models);
    }
    interface IView{
        void onSuccess(String url);
        void onError(String url);
    }
    interface IPresenter{
        void Presenter(String url);
    }
    interface Models{
        void onSuccess(String url);
        void onError(String url);
    }
}
