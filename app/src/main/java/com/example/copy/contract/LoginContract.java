package com.example.copy.contract;


import com.example.copy.base.IBaseView;
import com.example.copy.base.IPresenter;
import com.example.copy.bean.UserBean;

public interface LoginContract {

    interface View extends IBaseView {
        void loginReturn(UserBean result);
    }

    interface Presenter extends IPresenter<View> {
        void login(String nickname, String password);
    }
}
