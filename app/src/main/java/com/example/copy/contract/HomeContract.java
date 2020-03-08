package com.example.copy.contract;


import com.example.copy.base.IBaseView;
import com.example.copy.base.IPresenter;
import com.example.copy.bean.IndexBean;

public interface HomeContract {
    interface View extends IBaseView {
        void homeData(IndexBean bean);
    }
    interface Presenter extends IPresenter<View> {
        void getHomeData();
    }
}
