package com.example.copy.presenter;


import com.example.copy.base.BasePresenter;
import com.example.copy.bean.VerifyBean;
import com.example.copy.component.CommonSubscriber;
import com.example.copy.contract.LogenContract;
import com.example.copy.model.HttpManager;
import com.example.copy.utils.RxUtils;

public class LogenPresenter extends BasePresenter<LogenContract.View> implements LogenContract.Presenter {
    @Override
    public void getVerify() {
        addSubscribe(HttpManager.getMyApi().getVerify()
                .compose(RxUtils.<VerifyBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<VerifyBean>(mView){

                    @Override
                    public void onNext(VerifyBean verifyBean) {
                        mView.getVerifyReturn(verifyBean);
                    }
                }));
    }
}
