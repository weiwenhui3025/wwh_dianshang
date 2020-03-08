package com.example.copy.contract;


import com.example.copy.base.IBaseView;
import com.example.copy.base.IPresenter;
import com.example.copy.bean.IndexBean;

public interface ZhuanTiContract {

    interface View extends IBaseView {
        void getZhuanTi(IndexBean zhuanti);
    }

    interface Presenter extends IPresenter<View> {
        void getZhuanTiData();
    }

}
