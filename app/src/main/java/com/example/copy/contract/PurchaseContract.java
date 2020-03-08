package com.example.copy.contract;


import com.example.copy.base.IBaseView;
import com.example.copy.base.IPresenter;
import com.example.copy.bean.RelatedBean;

public interface PurchaseContract {

    interface View extends IBaseView {
        void getRelatedDataReturn(RelatedBean result);
    }

    interface Presenter extends IPresenter<View> {
        void getRelatedData(int id);
    }
}
