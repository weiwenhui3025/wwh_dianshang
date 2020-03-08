package com.example.copy.contract;


import com.example.copy.base.IBaseView;
import com.example.copy.base.IPresenter;
import com.example.copy.bean.CatalogListBean;
import com.example.copy.bean.CatalogTabBean;

public interface FenLeiContract {
    interface View extends IBaseView {
        void getsortData(CatalogTabBean catalogTabBean);
        void getFenLei(CatalogListBean catalogListBean);
    }

    interface Presenter extends IPresenter<View> {
        void getsort();
        void getFenLeiData(int id);
    }
}
