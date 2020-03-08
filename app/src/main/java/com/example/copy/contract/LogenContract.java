package com.example.copy.contract;


import com.example.copy.base.IBaseView;
import com.example.copy.base.IPresenter;
import com.example.copy.bean.VerifyBean;

public interface LogenContract {

    interface View extends IBaseView {
        void getVerifyReturn(VerifyBean result);
    }

    interface Presenter extends IPresenter<View> {
        void getVerify();
    }
}
