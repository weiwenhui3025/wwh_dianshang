package com.example.copy.presenter;


import com.example.copy.base.BasePresenter;
import com.example.copy.bean.UserBean;
import com.example.copy.component.CommonSubscriber;
import com.example.copy.contract.LoginContract;
import com.example.copy.model.HttpManager;
import com.example.copy.utils.RxUtils;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    @Override
    public void login(String nickname, String password) {
        addSubscribe(HttpManager.getMyApi().login(nickname,password)
                .compose(RxUtils.<UserBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<UserBean>(mView){

                    @Override
                    public void onNext(UserBean userBean) {
                        if(userBean.getErrno() == 0){
                            mView.loginReturn(userBean);
                        }
                    }
                }));
    }
}
