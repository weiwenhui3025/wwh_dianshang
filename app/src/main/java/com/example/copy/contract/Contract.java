package com.example.copy.contract;

import com.example.copy.base.BasePresenter;
import com.example.copy.base.BaseView;
import com.example.copy.utli.NetWorkUtli.NetWorkCallBack.NetWorkCallback;

public interface Contract {
    interface HomeModel{
        void get(String url, NetWorkCallback callback);
    }
    interface HomePresenter extends BasePresenter{
        void get(String url);
    }
    interface HomeView extends BaseView{
        void Success(String json);
        void Error(String error);
    }
}
