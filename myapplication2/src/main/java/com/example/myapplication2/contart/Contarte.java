package com.example.myapplication2.contart;

import java.util.zip.Inflater;

public interface Contarte {
    interface MyModel{
        void ModelInfo(String url,Models models);
    }
    interface MyView{
        void onSuccess(String url);
        void onError(String error);
    }
    interface MyPresenter{
        void PresenterInfo(String url);
    }
    interface Models{
        void onSuccess(String url);
        void onError(String error);
    }
}
