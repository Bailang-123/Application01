package com.example.monthlya.contrat;

import java.util.Map;

public interface IContrat {
    interface IModel{
        void getmodelInfo(String url,Class cls,Models models);
        void postmodelInfo(String url, Class cls, Map<String,Object> map, Models models);
    }
    interface IView<T>{
        void onSuccess(T t);
        void onError(String url);
    }

    interface IPresenter{
        void getPresenterInfo(String url,Class cls);
        void postPresenterInfo(String url, Class cls,Map<String,Object> map);
    }
    interface Models<T>{
        void onSuccess(T t);
        void onError(String url);
    }
}
