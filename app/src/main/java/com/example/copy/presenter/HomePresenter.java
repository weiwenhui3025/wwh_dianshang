package com.example.copy.presenter;

import com.example.copy.base.BaseView;
import com.example.copy.contract.Contract;
import com.example.copy.model.HomeModel;
import com.example.copy.utli.NetWorkUtli.NetWorkCallBack.NetWorkCallback;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

public class HomePresenter implements Contract.HomePresenter {
    private Contract.HomeModel model;
    private Contract.HomeView view;

    public HomePresenter() {
        this.model = new HomeModel();
    }

    @Override
    public void Attach(BaseView view) {
        this.view= (Contract.HomeView) view;
    }

    @Override
    public void delete() {
        this.view=null;
    }

    @Override
    public void get(String url) {
        if (model!=null){
            model.get(url, new NetWorkCallback() {
                @Override
                public void Success(String json) {
                    if (view!=null){
                        view.Success(json);
                    }
                }

                @Override
                public void Error(String error) {
                    if (view!=null){
                        view.Error(error);
                    }
                }
            });
        }
    }
}
